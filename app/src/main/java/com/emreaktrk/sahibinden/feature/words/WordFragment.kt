package com.emreaktrk.sahibinden.feature.words

import android.os.Bundle
import android.view.View
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.presentation.BaseFragment
import com.emreaktrk.presentation.BindingSupport
import com.emreaktrk.presentation.ViewModelSupport
import com.emreaktrk.sahibinden.R
import com.emreaktrk.sahibinden.databinding.FragmentWordBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WordFragment : BaseFragment<FragmentWordBinding>(R.layout.fragment_word),
    BindingSupport,
    ViewModelSupport,
    WordViewModel.ActionHandler {

    @Inject
    lateinit var vm: WordViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.actionHandler = this
        requireBinding().vm = vm

        vm.getWords()
    }

    override fun onError(message: String) {
        Snackbar
            .make(requireView(), message, Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onLoad(list: List<WordModel>) {
        Snackbar
            .make(requireView(), "Words loaded.", Snackbar.LENGTH_LONG)
            .show()

        val adapter = WordAdapter(list)
        requireBinding().recycler.adapter = adapter
    }
}