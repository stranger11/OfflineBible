package com.example.offlinebible.data.cache

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book

interface BookCacheMapper : Abstract.Mapper {

    fun map(bookDb: BookDb) : Book

    class Base: BookCacheMapper {
        override fun map(bookDb: BookDb): Book = Book(bookDb.id, bookDb.name)
    }
}