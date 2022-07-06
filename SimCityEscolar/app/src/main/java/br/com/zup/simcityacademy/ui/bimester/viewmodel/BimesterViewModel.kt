package br.com.zup.simcityacademy.ui.bimester.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.usecase.BimesterUseCase
import br.com.zup.simcityacademy.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BimesterViewModel(application: Application) : AndroidViewModel(application) {
    private val bimesterUseCase = BimesterUseCase(application)
    var viewState =  ViewState()


    fun insertBimester(bimester: Bimester) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    bimesterUseCase.insertBimester(bimester)
                }
                viewState.state.value= ViewState.State.SUCCESS
                getBimester(bimester.bimesterNumber)
            } catch (ex: Exception) {
                viewState.state.value = ViewState.State.ERROR
            }
        }
    }

    fun getBimester(bimesterNumber: Int) {
        viewModelScope.launch {
            try {
               val response = withContext(Dispatchers.IO) {
                    bimesterUseCase.getBimester(bimesterNumber)
                }
                viewState.bimester.value = response
                viewState.state.value = ViewState.State.SUCCESS
            } catch (ex: Exception) {
                viewState.state.value = ViewState.State.ERROR
            }
        }
    }
}