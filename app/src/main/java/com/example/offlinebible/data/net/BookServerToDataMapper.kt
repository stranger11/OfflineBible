package com.example.offlinebible.data.net

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.data.BookData

interface BookServerToDataMapper: Abstract.Mapper {
    fun map(id: Int, name: String): BookData
}