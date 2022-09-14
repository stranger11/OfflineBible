package com.example.offlinebible.data.cache

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>) : List<Book>

    class Base(private val mapper: BookCacheMapper): BooksCacheMapper {
        override fun map(books: List<BookDb>): List<Book> = books.map { bookDb ->
            bookDb.map(mapper)
        }
    }
}