package com.dmytros.servicelocatorfordi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
val debugModule = module {

    factory(override = true) {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
    }
}