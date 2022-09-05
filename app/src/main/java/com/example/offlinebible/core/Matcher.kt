package com.example.offlinebible.core


/**
 * @author stranger11 on 05.09.2022
 **/
interface Matcher<T> {

    fun matches(arg: T): Boolean
}