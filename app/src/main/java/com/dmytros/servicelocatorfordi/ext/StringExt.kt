package com.dmytros.servicelocatorfordi.ext

import java.security.MessageDigest

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */

fun String.toMD5(): String {
    val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
    return bytes.toHex()
}

fun ByteArray.toHex(): String {
    return joinToString("") { "%02x".format(it) }
}
