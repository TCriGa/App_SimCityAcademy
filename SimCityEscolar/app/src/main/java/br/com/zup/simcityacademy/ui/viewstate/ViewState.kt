package br.com.zup.simcityacademy.ui.viewstate

import androidx.lifecycle.MutableLiveData
import br.com.zup.simcityacademy.domain.model.Bimester


class ViewState {
    val bimester = MutableLiveData<List<Bimester>>()
    val state: MutableLiveData<State> = MutableLiveData()

    enum class State {
        SUCCESS, ERROR
    }
}
