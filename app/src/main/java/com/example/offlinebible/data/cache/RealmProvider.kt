package com.example.offlinebible.data.cache

import io.realm.Realm

interface RealmProvider {

    fun provide() : Realm

    class Base() : RealmProvider {
        override fun provide(): Realm = Realm.getDefaultInstance()
    }
}