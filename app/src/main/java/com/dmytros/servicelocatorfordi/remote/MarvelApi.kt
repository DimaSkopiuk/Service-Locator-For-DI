package com.dmytros.servicelocatorfordi.remote

import com.dmytros.servicelocatorfordi.Config
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
interface MarvelApi {

    @GET("/v1/public/characters")
    suspend fun characters(
        @Query("ts") ts: String,
        @Query("hash") hash: String,
        @Query("apikey") apiKey: String = Config.API_KEY
    ): ResponseBody
}