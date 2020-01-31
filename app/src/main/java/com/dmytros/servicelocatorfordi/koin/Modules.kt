package com.dmytros.servicelocatorfordi.koin

import com.dmytros.servicelocatorfordi.Config
import com.dmytros.servicelocatorfordi.data.MainViewModel
import com.dmytros.servicelocatorfordi.remote.*
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
val coreModule = module {

    single { get<Retrofit>().create(MarvelApi::class.java) }
    single { get<Retrofit.Builder>().build() }
    factory {
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .addConverterFactory(get<JacksonConverterFactory>())
            .client(get<OkHttpClient.Builder>().build())
    }
    factory { JacksonConverterFactory.create(jacksonObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)) }
    factory { OkHttpClient.Builder() }

    factory { AuthSession() }
    single { MarvelCharacterListDataSource() }
    single { MarvelCharactersRepository() }
    single { MarvelCharacterMapper() }

    viewModel { MainViewModel() }
}