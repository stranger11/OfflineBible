package com.example.offlinebible.data

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.data.net.BookServerModel
import com.example.offlinebible.domain.BookDomain
import java.lang.Exception

sealed class BookData: Abstract.Object<BookDomain, BookDataToDomainMapper>() {

    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BookDataToDomainMapper): BookDomain {
            return mapper.map(books)
        }
    }

    class Fail(private val e: Exception): BookData() {
        override fun map(mapper: BookDataToDomainMapper): BookDomain {
            return  mapper.map(e)
        }
    }
}