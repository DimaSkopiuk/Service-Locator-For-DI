package com.dmytros.servicelocatorfordi.remote

import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MarvelCharacterListDataSource : KoinComponent {

    private val marvelApi: MarvelApi by inject()
    private val mapper: MarvelCharacterMapper by inject()

    suspend fun request(authSession: AuthSession) = marvelApi.characters(authSession.timestamp, authSession.hash)
        .let { result -> mapper.toCore(result) }
}