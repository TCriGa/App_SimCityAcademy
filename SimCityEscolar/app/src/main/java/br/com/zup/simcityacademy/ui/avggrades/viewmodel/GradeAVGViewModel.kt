package br.com.zup.simcityacademy.ui.avggrades.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.usecase.BimesterUseCase
import br.com.zup.simcityacademy.ui.viewstate.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class GradeAVGViewModel(application: Application) : AndroidViewModel(application) {

}