package com.emreaktrk.sahibinden.feature.detail

import android.os.Bundle
import android.view.View
import com.emreaktrk.presentation.BaseFragment
import com.emreaktrk.presentation.BindingSupport
import com.emreaktrk.presentation.ViewModelSupport
import com.emreaktrk.sahibinden.R
import com.emreaktrk.sahibinden.databinding.FragmentDetailBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail),
    BindingSupport,
    ViewModelSupport,
    DetailViewModel.ActionHandler {

    @Inject
    lateinit var vm: DetailViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.actionHandler = this
        requireBinding().vm = vm
        requireBinding().lifecycleOwner

        arguments?.let {
            val id = DetailFragmentArgs.fromBundle(it).id
            vm.getDetail(id)
        }
    }

    override fun onError(message: String) {
        Snackbar
            .make(requireView(), message, Snackbar.LENGTH_LONG)
            .show()
    }
}