package com.dmytros.servicelocatorfordi

import android.app.Application
import com.dmytros.servicelocatorfordi.koin.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(coreModule)
        }
    }
}