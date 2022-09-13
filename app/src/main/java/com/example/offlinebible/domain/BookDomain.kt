package com.example.offlinebible.domain

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, BookDomainToUiMapper>() {
}