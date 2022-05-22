package com.emreaktrk.sahibinden.feature.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.emreaktrk.domain.AuthenticationUseCase
import com.emreaktrk.sahibinden.account.AccountEditor
import com.emreaktrk.sahibinden.account.Me
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@FragmentScoped
class LoginViewModel @Inject constructor(
    application: Application,
    private val useCase: AuthenticationUseCase,
    private val accountEditor: AccountEditor,
) : AndroidViewModel(application) {

    var actionHandler: ActionHandler? = null

    val email = MutableLiveData("ozgunergen@yandex.com")
    val password = MutableLiveData<String>("Qaz!123")

    fun authenticate() {
        viewModelScope.launch {
            val params = AuthenticationUseCase.Params(
                email.value,
                password.value
            )
            useCase(params)
                .catch {
                    val message = it.message.toString()
                    actionHandler?.onError(message)
                }
                .collect {
                    val me = Me(email.value!!)
                    accountEditor.login(it, me)

                    actionHandler?.onAuthenticated()
                }
        }
    }

    interface ActionHandler {
        fun onError(message: String)
        fun onAuthenticated()
    }
}