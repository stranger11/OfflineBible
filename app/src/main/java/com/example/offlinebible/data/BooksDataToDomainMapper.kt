package com.example.offlinebible.data

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book
import com.example.offlinebible.domain.BookDomain
import java.lang.Exception

interface BooksDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<Book>): BookDomain
    fun map(e: Exception): BookDomain
}