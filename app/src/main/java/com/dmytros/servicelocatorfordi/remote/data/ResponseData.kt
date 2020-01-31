package com.dmytros.servicelocatorfordi.remote.data

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
data class ResponseData<T>(val offset: Int, val limit: Int, val total: Int, val count: Int, val results: List<T>)