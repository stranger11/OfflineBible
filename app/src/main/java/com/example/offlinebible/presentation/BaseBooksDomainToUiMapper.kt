package com.example.offlinebible.presentation

import com.example.offlinebible.core.Book
import com.example.offlinebible.domain.BooksDomainToUiMapper
import com.example.offlinebible.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val communication: BooksCommunication,
    private val resourceProvider: ResourceProvider
) : BooksDomainToUiMapper {

    override fun map(books: List<Book>): BooksUi = BooksUi.Success(communication, books)

    override fun map(errorType: ErrorType): BooksUi =
        BooksUi.Fail(errorType, communication, resourceProvider)

}