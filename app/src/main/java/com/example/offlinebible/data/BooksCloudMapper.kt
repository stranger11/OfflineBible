package com.example.offlinebible.data

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book
import com.example.offlinebible.data.net.BookCloud
import com.example.offlinebible.data.net.BookCloudMapper

interface BooksCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<BookCloud>): List<Book>

    class Base(private val bookMapper: BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>): List<Book> = cloudList.map { bookCloud ->
            bookCloud.map(bookMapper)
        }
    }
}