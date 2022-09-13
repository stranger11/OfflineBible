package com.example.offlinebible.data

import com.example.offlinebible.data.net.BookServerModel
import com.example.offlinebible.data.net.BooksService

interface BooksCloudDataSource {
    suspend fun fetchBooks() : List<BookServerModel>

    class Base(private val service: BooksService): BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookServerModel> = service.fetchBooks()
    }
}