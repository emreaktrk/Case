package com.emreaktrk.sahibinden.feature.login

import android.os.Bundle
import android.view.View
import com.emreaktrk.presentation.BaseFragment
import com.emreaktrk.presentation.BindingSupport
import com.emreaktrk.presentation.ViewModelSupport
import com.emreaktrk.sahibinden.R
import com.emreaktrk.sahibinden.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login),
    BindingSupport,
    ViewModelSupport,
    LoginViewModel.ActionHandler {

    @Inject
    lateinit var vm: LoginViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.actionHandler = this
        requireBinding().vm = vm
    }

    override fun onError(message: String) {
        Snackbar
            .make(requireView(), message, Snackbar.LENGTH_LONG)
            .show()
    }

    override fun onAuthenticated() {
        Snackbar
            .make(requireView(), "Logged In", Snackbar.LENGTH_LONG)
            .show()
    }
}