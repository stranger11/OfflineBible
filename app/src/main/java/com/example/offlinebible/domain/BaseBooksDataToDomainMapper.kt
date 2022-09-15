package com.example.offlinebible.domain

import com.example.offlinebible.core.Book
import com.example.offlinebible.data.BooksDataToDomainMapper
import java.lang.Exception

class BaseBooksDataToDomainMapper : BooksDataToDomainMapper {
    override fun map(books: List<Book>): BookDomain {
        return BookDomain.Success(books)
    }

    override fun map(e: Exception): BookDomain {
        return BookDomain.Fail(e)
    }
}