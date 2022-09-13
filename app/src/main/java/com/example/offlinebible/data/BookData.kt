package com.example.offlinebible.data

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.domain.BookDomain

sealed class BookData: Abstract.Object<BookDomain, BookDataToDomainMapper>() {
}