package com.example.offlinebible.domain.books

import com.example.offlinebible.core.Abstract

interface BooksDomainToUiMapper<T> : Abstract.Mapper.DomainToUi<List<BookDomain>, T>