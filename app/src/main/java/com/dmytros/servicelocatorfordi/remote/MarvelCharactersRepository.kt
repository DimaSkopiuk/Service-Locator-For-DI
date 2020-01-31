package com.dmytros.servicelocatorfordi.remote

import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MarvelCharactersRepository : KoinComponent {

    private val authSession: AuthSession get() = get()
    private val characterListDataSource: MarvelCharacterListDataSource by inject()

    suspend fun requestList() = characterListDataSource.request(authSession)
}