package com.example.offlinebible.core

interface Matcher<T> {

    fun matches(arg: T): Boolean
}