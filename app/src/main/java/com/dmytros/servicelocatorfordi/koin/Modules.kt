package com.dmytros.servicelocatorfordi.koin

import com.dmytros.servicelocatorfordi.Config
import com.dmytros.servicelocatorfordi.MainViewModel
import com.dmytros.servicelocatorfordi.remote.AuthSession
import com.dmytros.servicelocatorfordi.remote.MarvelApi
import com.dmytros.servicelocatorfordi.remote.MarvelCharacterListDataSource
import com.dmytros.servicelocatorfordi.remote.MarvelCharactersRepository
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
val coreModule = module {

    single { get<Retrofit>().create(MarvelApi::class.java) }
    single { get<Retrofit.Builder>().build() }
    factory {
        Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .client(get<OkHttpClient.Builder>().build())
    }
    factory { OkHttpClient.Builder() }

    factory { AuthSession() }
    single { MarvelCharacterListDataSource() }
    single { MarvelCharactersRepository() }

    viewModel { MainViewModel() }
}