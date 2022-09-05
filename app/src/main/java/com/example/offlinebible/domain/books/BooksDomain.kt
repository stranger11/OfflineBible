package com.example.offlinebible.domain.books

import com.example.offlinebible.core.ErrorType

sealed class BooksDomain {

    abstract fun <T>map(mapper: BooksDomainToUiMapper<T>): T

    data class Success(private val books: List<BookDomain>) : BooksDomain() {
        override fun <T> map(mapper: BooksDomainToUiMapper<T>) = mapper.map(books)
    }

    data class Fail(private val errorType: ErrorType) : BooksDomain() {
        override fun <T> map(mapper: BooksDomainToUiMapper<T>) = mapper.map(errorType)
    }
}