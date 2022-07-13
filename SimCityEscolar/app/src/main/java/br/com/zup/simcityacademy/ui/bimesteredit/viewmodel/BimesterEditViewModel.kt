package br.com.zup.simcityacademy.ui.bimesteredit.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.usecase.BimesterUseCase
import br.com.zup.simcityacademy.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BimesterEditViewModel(application: Application): AndroidViewModel(application) {

    private val bimesterUseCase = BimesterUseCase(application)
    val viewState = ViewState()

    fun updateBimester(bimester: Bimester) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    bimesterUseCase.updateGrades(bimester)
                }
                viewState.state.value = ViewState.State.SUCCESS
            } catch (ex: Exception) {
                viewState.state.value = ViewState.State.ERROR
            }
        }
    }
}