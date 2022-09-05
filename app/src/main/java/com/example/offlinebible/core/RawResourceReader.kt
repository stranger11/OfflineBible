package com.example.offlinebible.core

import androidx.annotation.RawRes


/**
 * @author stranger11 on 05.09.2022
 **/
interface RawResourceReader {

    fun readText(@RawRes id: Int): String
}