package com.emreaktrk.sahibinden.feature.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.emreaktrk.domain.AuthenticationUseCase
import com.emreaktrk.presentation.BaseFragment
import com.emreaktrk.sahibinden.R
import com.emreaktrk.sahibinden.account.AccountEditor
import com.emreaktrk.sahibinden.account.Me
import com.emreaktrk.sahibinden.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(R.layout.fragment_login) {

    @Inject
    lateinit var useCase: AuthenticationUseCase

    @Inject
    lateinit var accountEditor: AccountEditor

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val params = AuthenticationUseCase.Params(
                "emreaktrk@hotmail.com",
                "123456"
            )
            useCase(params)
                .catch {
                    Snackbar
                        .make(view, it.message.toString(), Snackbar.LENGTH_LONG)
                        .show()
                }
                .collect {
                    val me = Me("emreaktrk@hotmail.com")
                    accountEditor.login(it, me)
                }
        }
    }
}