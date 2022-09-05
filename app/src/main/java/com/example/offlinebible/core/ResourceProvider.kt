package com.example.offlinebible.core

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.os.LocaleList
import androidx.annotation.StringRes
import java.io.BufferedReader
import java.util.*


/**
 * @author stranger11 on 05.09.2022
 **/
interface ResourceProvider: RawResourceReader, PreferencesProvider, ChooseLanguages {

    fun string(@StringRes id: Int): String
    fun string(@StringRes id: Int, vararg args: Any): String

    class Base(private var context: Context) : ResourceProvider {
        override fun string(id: Int): String = context.getString(id)

        override fun string(id: Int, vararg args: Any): String = context.getString(id, *args)

        override fun readText(id: Int) = context.resources.openRawResource(id).bufferedReader()
            .use(BufferedReader::readText)

        override fun provideSharedPreferences(name: String): SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)

        override fun chooseEnglish() = changeLanguage("en", Locale.ENGLISH)

        override fun chooseRussian() = changeLanguage("ru", Locale("ru", "RU"))

        private fun changeLanguage(lang: String, locale: Locale) {
            val conf = context.resources.configuration
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                conf.setLocales(LocaleList.forLanguageTags(lang))
            else
                conf.setLocale(locale)
            context = context.createConfigurationContext(conf)
        }

    }
}