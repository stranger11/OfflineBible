package com.example.offlinebible.data

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book
import com.example.offlinebible.domain.BookDomain
import java.lang.Exception

sealed class BooksData: Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(books)
    }
    class Fail(private val e: Exception): BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain = mapper.map(e)
    }
}