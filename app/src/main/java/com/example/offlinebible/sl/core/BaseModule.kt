package com.example.offlinebible.sl.core

import androidx.lifecycle.ViewModel

/**
 * @author stranger11 on 05.09.2022
 **/


interface BaseModule<T: ViewModel> {

    fun viewModule(): T
}