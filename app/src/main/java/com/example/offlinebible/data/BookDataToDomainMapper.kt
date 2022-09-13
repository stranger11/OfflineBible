package com.example.offlinebible.data

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.data.net.BookServerModel
import com.example.offlinebible.domain.BookDomain
import retrofit2.HttpException
import java.lang.Exception
import java.net.UnknownHostException

interface BookDataToDomainMapper : Abstract.Mapper {
    fun map(books: List<BookServerModel>): BookDomain
    fun map(e: Exception): BookDomain

    class Base : BookDataToDomainMapper {
        override fun map(books: List<BookServerModel>): BookDomain = BookDomain.Success(books)


        override fun map(e: Exception): BookDomain {
            val errorType = when(e) {
                is UnknownHostException -> 0 // enum class ErrorType.NoConnection
                is HttpException -> 1 // ServiceUnavailable
                else -> 2 // GenericException
            }
            return BookDomain.Fail(errorType)
        }

    }
}