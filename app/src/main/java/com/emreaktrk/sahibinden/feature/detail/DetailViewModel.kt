package com.emreaktrk.sahibinden.feature.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.emreaktrk.core.model.WordModel
import com.emreaktrk.domain.GetWordUseCase
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@FragmentScoped
class DetailViewModel @Inject constructor(
    application: Application,
    private val useCase: GetWordUseCase
) : AndroidViewModel(application) {

    var actionHandler: ActionHandler? = null

    val word = MutableLiveData<WordModel>()

    fun getDetail(id: String) {
        viewModelScope.launch {
            useCase(id)
                .catch {
                    val message = it.message.toString()
                    actionHandler?.onError(message)
                }
                .collect {
                    word.value = it
                }
        }
    }

    interface ActionHandler {
        fun onError(message: String)
    }
}