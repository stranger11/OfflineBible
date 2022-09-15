package com.example.offlinebible.domain

import com.example.offlinebible.data.BooksDataToDomainMapper
import com.example.offlinebible.data.BooksRepository

interface BooksInteractor {

    suspend fun fetchBooks(): BookDomain

    class Base(
        private val booksRepository: BooksRepository,
        private val mapper: BooksDataToDomainMapper
    ) : BooksInteractor {
        override suspend fun fetchBooks() = booksRepository.fetchBooks().map(mapper)
    }
}