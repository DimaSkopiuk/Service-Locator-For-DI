package com.dmytros.servicelocatorfordi

import android.annotation.SuppressLint
import org.koin.core.context.GlobalContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
@SuppressLint("Registered")
class DebugApplication : MyApplication() {

    override fun onCreate() {
        GlobalContext.getOrNull()?.let { stopKoin() }
        super.onCreate()
        loadKoinModules(debugModule)
    }
}