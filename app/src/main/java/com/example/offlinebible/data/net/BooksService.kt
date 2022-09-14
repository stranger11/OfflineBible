package com.example.offlinebible.data.net

import retrofit2.http.GET

interface BooksService {

    @GET("books")
    suspend fun fetchBooks(): List<BookCloud>
}


//https://bible-go-api.rkeplin.com/v1/ baseUrl