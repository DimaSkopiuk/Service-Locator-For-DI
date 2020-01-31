package com.dmytros.servicelocatorfordi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dmytros.servicelocatorfordi.data.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Dima Skopiuk on 31.01.2020.
 */
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.requestCharacterList()
    }
}