package com.example.offlinebible.core

import android.app.Application
import com.example.offlinebible.data.BooksCloudDataSource
import com.example.offlinebible.data.BooksCloudMapper
import com.example.offlinebible.data.BooksRepository
import com.example.offlinebible.data.cache.BookCacheMapper
import com.example.offlinebible.data.cache.BooksCacheDataSource
import com.example.offlinebible.data.cache.BooksCacheMapper
import com.example.offlinebible.data.cache.RealmProvider
import com.example.offlinebible.data.net.BookCloudMapper
import com.example.offlinebible.data.net.BooksService
import com.example.offlinebible.domain.BaseBooksDataToDomainMapper
import com.example.offlinebible.domain.BooksInteractor
import com.example.offlinebible.presentation.BaseBooksDomainToUiMapper
import com.example.offlinebible.presentation.BooksCommunication
import com.example.offlinebible.presentation.MainViewModel
import com.example.offlinebible.presentation.ResourceProvider
import io.realm.Realm
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(BooksService::class.java)

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
        val booksDataToDomainMapper = BaseBooksDataToDomainMapper()

        val booksInteractor =  BooksInteractor.Base(booksRepository, booksDataToDomainMapper)
        val communication = BooksCommunication.Base()
        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(
                communication,
                ResourceProvider.Base(this)
            ),
            communication
        )
    }
}