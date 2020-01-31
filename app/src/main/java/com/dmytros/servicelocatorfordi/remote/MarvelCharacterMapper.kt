package com.dmytros.servicelocatorfordi.remote

import com.dmytros.servicelocatorfordi.data.MarvelCharacter
import com.dmytros.servicelocatorfordi.remote.data.Character
import com.dmytros.servicelocatorfordi.remote.data.Response
import com.dmytros.servicelocatorfordi.remote.data.Thumbnail

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MarvelCharacterMapper {

    fun toCore(response: Response<Character>) = if (isOk(response)) response.data.results.map { toCore(it) } else emptyList()

    private fun toCore(character: Character) = MarvelCharacter(character.name, toPath(character.thumbnail))

    private fun toPath(thumbnail: Thumbnail) = "${thumbnail.path}.${thumbnail.extension}"

    private fun isOk(response: Response<*>) = response.code == "200" && response.status == "Ok"
}