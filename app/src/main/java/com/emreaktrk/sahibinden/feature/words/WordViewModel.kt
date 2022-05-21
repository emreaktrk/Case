package com.emreaktrk.sahibinden.feature.words

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.emreaktrk.core.model.Token
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.domain.GetWordsOfflineFirstUseCase
import com.emreaktrk.sahibinden.account.AccountEditor
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@FragmentScoped
class WordViewModel @Inject constructor(
    application: Application,
    private val useCase: GetWordsOfflineFirstUseCase,
    private val accountEditor: AccountEditor,
) : AndroidViewModel(application) {

    var actionHandler: ActionHandler? = null

    fun getWords() {
        viewModelScope.launch {
            val token = getToken()
            useCase(token)
                .catch {
                    val message = it.message.toString()
                    actionHandler?.onError(message)
                }
                .collect {
                    actionHandler?.onLoad(it)
                }
        }
    }

    private suspend fun getToken(): Token? = withContext(Dispatchers.IO) {
        accountEditor.token
    }

    interface ActionHandler {
        fun onError(message: String)
        fun onLoad(list: List<WordModel>)
    }
}