package com.dmytros.servicelocatorfordi

import android.annotation.SuppressLint
import org.koin.core.context.loadKoinModules

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
@SuppressLint("Registered")
class DebugApplication : MyApplication() {

    override fun onCreate() {
        super.onCreate()
        loadKoinModules(debugModule)
    }
}