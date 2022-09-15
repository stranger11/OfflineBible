package com.example.offlinebible.domain

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book
import com.example.offlinebible.presentation.BooksUi

interface BooksDomainToUiMapper : Abstract.Mapper {

    fun map(books: List<Book>) : BooksUi

    fun map(errorType: ErrorType) : BooksUi
}