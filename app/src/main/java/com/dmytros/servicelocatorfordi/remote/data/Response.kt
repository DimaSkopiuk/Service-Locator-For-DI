package com.dmytros.servicelocatorfordi.remote.data

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
data class Response<T>(val code: String, val status: String, val copyright: String, val attributionText: String, val data: ResponseData<T>)