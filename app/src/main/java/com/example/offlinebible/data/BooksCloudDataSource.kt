package com.example.offlinebible.data

import com.example.offlinebible.core.Book
import com.example.offlinebible.data.net.BookCloud
import com.example.offlinebible.data.net.BooksService

interface BooksCloudDataSource {
    suspend fun fetchBooks() : List<BookCloud>

    class Base(private val service: BooksService): BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> = service.fetchBooks()
    }
}