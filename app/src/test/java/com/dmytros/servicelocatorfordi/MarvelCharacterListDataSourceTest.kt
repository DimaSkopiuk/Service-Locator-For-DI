package com.dmytros.servicelocatorfordi

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dmytros.servicelocatorfordi.remote.AuthSession
import com.dmytros.servicelocatorfordi.remote.MarvelApi
import com.dmytros.servicelocatorfordi.remote.MarvelCharacterListDataSource
import com.dmytros.servicelocatorfordi.remote.MarvelCharacterMapper
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.inject

/**
 * Created by Dima Skopiuk on 01.02.2020.
 */
@RunWith(AndroidJUnit4::class)
class MarvelCharacterListDataSourceTest : KoinTest {

    private val marvelApi: MarvelApi by declareMockk { coEvery { characters(any(), any(), any()) } returns DataFixture.characterResponse }
    private val mapper: MarvelCharacterMapper by declareMockk()
    private val authSession: AuthSession by inject()
    private val dataSource: MarvelCharacterListDataSource by inject()

    @Test
    fun `api call uses proper params`() {
        runBlocking { dataSource.request(authSession) }
        coVerify(exactly = 1) { marvelApi.characters(authSession.timestamp, authSession.hash, Config.API_KEY) }
    }

    @Test
    fun `mapper is called`() {
        runBlocking { dataSource.request(authSession) }
        verify(exactly = 1) { mapper.toCore(DataFixture.characterResponse) }
    }
}