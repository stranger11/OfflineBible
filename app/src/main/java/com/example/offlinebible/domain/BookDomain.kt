package com.example.offlinebible.domain

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.data.net.BookServerModel
import com.example.offlinebible.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, BookDomainToUiMapper>() {

    class Success(private val books: List<BookServerModel>) : BookDomain() {
        override fun map(mapper: BookDomainToUiMapper): BookUi {
            TODO("Not yet implemented")
        }

    }

    class Fail(errorType: Int) : BookDomain() {
        override fun map(mapper: BookDomainToUiMapper): BookUi {
            TODO("Not yet implemented")
        }

    }

}