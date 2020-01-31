package com.dmytros.servicelocatorfordi.remote

import okhttp3.ResponseBody
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MarvelCharacterListDataSource : KoinComponent {

    private val marvelApi: MarvelApi by inject()

    suspend fun request(authSession: AuthSession): ResponseBody = marvelApi.characters(authSession.timestamp, authSession.hash)
}