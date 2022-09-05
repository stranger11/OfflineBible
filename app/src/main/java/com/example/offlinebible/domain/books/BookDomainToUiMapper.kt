package com.example.offlinebible.domain.books

import androidx.annotation.StringRes
import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.ResourceProvider


/**
 * @author stranger11 on 05.09.2022
 **/
interface BookDomainToUiMapper<T> : Abstract.Mapper {

    fun map(id: Int, name: String, isFavorite: Boolean = false): T

    class Name(
        private val resourceProvider: ResourceProvider,
        @StringRes private val stringResId: Int,
        private val arg: Any
    ) : BookDomainToUiMapper<String> {
        override fun map(id: Int, name: String, isFavorite: Boolean) =
            resourceProvider.string(stringResId, name, arg)
    }
}