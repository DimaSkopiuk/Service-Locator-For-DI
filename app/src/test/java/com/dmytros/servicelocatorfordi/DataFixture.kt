package com.dmytros.servicelocatorfordi

import com.dmytros.servicelocatorfordi.remote.data.Character
import com.dmytros.servicelocatorfordi.remote.data.Response
import com.dmytros.servicelocatorfordi.remote.data.ResponseData
import com.dmytros.servicelocatorfordi.remote.data.Thumbnail

/**
 * Created by Dima Skopiuk on 01.02.2020.
 */
object DataFixture {

    val characterResponseData = ResponseData(0, 20, 200, 20, listOf(character("1"), character("2")))
    val characterResponse = Response("200", "Ok", "copyright", "", characterResponseData)

    private fun character(prefix: String) = Character(prefix.hashCode(), "Name $prefix", "description $prefix", thumbnail(prefix))
    private fun thumbnail(prefix: String) = Thumbnail("http://marvel.com/thumbnail/$prefix", "jpg")
}