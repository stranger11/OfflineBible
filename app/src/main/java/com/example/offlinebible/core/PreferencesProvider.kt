package com.example.offlinebible.core

import android.content.SharedPreferences


/**
 * @author stranger11 on 05.09.2022
 **/
interface PreferencesProvider {

    fun provideSharedPreferences(name: String): SharedPreferences
}