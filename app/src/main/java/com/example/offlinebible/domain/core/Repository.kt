package com.example.offlinebible.domain.core

import com.example.offlinebible.core.Abstract
import com.example.offlinebible.core.ChangeFavorite


/**
 * @author stranger11 on 05.09.2022
 **/
interface Repository<E: Abstract.DataObject> : ChangeFavorite<Int> {
    suspend fun fetchData(): E
}