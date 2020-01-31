package com.dmytros.servicelocatorfordi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmytros.servicelocatorfordi.remote.MarvelCharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MainViewModel : ViewModel(), KoinComponent {

    private val marvelCharactersRepository: MarvelCharactersRepository by inject()

    fun requestCharacterList() {
        viewModelScope.launch(Dispatchers.IO) { marvelCharactersRepository.requestList() }
    }
}