package com.example.offlinebible.core

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.offlinebible.data.BooksCloudDataSource
import com.example.offlinebible.data.BooksCloudMapper
import com.example.offlinebible.data.BooksRepository
import com.example.offlinebible.data.cache.BookCacheMapper
import com.example.offlinebible.data.cache.BooksCacheDataSource
import com.example.offlinebible.data.cache.BooksCacheMapper
import com.example.offlinebible.data.cache.RealmProvider
import com.example.offlinebible.data.net.BookCloudMapper
import com.example.offlinebible.data.net.BooksService
import com.example.offlinebible.domain.BooksInteractor
import com.example.offlinebible.presentation.BaseBooksDomainToUiMapper
import com.example.offlinebible.presentation.BooksCommunication
import com.example.offlinebible.presentation.MainViewModel
import com.example.offlinebible.presentation.ResourceProvider
import retrofit2.Retrofit

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
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

        val booksInteractor: BooksInteractor = TODO()
        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(
                BooksCommunication.Base(),
                ResourceProvider.Base(this)
            )
        )
    }
}