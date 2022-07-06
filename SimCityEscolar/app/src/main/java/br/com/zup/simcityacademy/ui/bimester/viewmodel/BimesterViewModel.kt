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
    var viewState = ViewState()


    fun insertInformations(bimester: Bimester) {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    bimesterUseCase.insertBimester(bimester)
                }
                viewState.state.value= ViewState.State.SUCCESS
                getInformation()
            } catch (ex: Exception) {
                viewState.state.value = ViewState.State.ERROR
            }
        }
    }

    fun getInformation() {
        viewModelScope.launch {
            try {
               val response = withContext(Dispatchers.IO) {
                    bimesterUseCase.getBimester()
                }
                viewState.bimester.value = response
                viewState.state.value = ViewState.State.SUCCESS
            } catch (ex: Exception) {
                viewState.state.value = ViewState.State.ERROR
            }
        }
    }
}