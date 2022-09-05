package com.example.offlinebible.core

import android.content.SharedPreferences

interface PreferencesProvider {

    fun provideSharedPreferences(name: String): SharedPreferences
}