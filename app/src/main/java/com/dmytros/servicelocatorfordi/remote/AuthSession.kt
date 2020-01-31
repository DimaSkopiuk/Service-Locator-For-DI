package com.dmytros.servicelocatorfordi.remote

import com.dmytros.servicelocatorfordi.Config
import com.dmytros.servicelocatorfordi.ext.toMD5

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
data class AuthSession(
    val timestamp: String = System.currentTimeMillis().toString(),
    val hash: String = (timestamp + Config.SECRET + Config.API_KEY).toMD5()
)