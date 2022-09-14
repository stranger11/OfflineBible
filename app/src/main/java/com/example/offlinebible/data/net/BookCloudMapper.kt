package com.example.offlinebible.data.net

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book

interface BookCloudMapper: Abstract.Mapper {

    fun map(id: Int, name: String): Book

    class Base : BookCloudMapper {
        override fun map(id: Int, name: String): Book = Book(id, name)
    }
}