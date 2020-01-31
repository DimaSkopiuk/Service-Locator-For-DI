package com.dmytros.servicelocatorfordi.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.dmytros.servicelocatorfordi.R
import com.dmytros.servicelocatorfordi.data.MainViewModel
import com.dmytros.servicelocatorfordi.data.MarvelCharacter
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter: CharacterAdapter by inject()
    private val observer: Observer<List<MarvelCharacter>> = Observer { adapter.items = it }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.adapter = adapter
        viewModel.characterListLiveData.observe(viewLifecycleOwner, observer)
        viewModel.requestCharacterList()
    }
}