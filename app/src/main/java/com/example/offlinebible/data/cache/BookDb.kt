package com.example.offlinebible.data.cache

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Mapable<Book, BookCacheMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""

    override fun map(mapper: BookCacheMapper): Book = Book(id, name)
}