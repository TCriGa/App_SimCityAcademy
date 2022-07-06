package br.com.zup.simcityacademy.ui.viewstate

import androidx.lifecycle.MutableLiveData
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.model.SingleLiveEvent

class ViewState {
    val bimester = MutableLiveData<List<Bimester>>()
    val state: SingleLiveEvent<State> = SingleLiveEvent()

    enum class State {
        SUCCESS, ERROR
    }
}
