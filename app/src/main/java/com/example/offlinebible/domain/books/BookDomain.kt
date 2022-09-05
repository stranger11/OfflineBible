package com.example.offlinebible.domain.books

sealed class BookDomain {

    abstract fun <T> map(mapper: BookDomainToUiMapper<T>): T

    data class Base(
        private val id: Int, private val name: String, private val isFavorite: Boolean = false
    ) : BookDomain() {
        override fun <T> map(mapper: BookDomainToUiMapper<T>): T = mapper.map(id, name, isFavorite)
    }
}