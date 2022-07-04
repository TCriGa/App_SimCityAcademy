package br.com.zup.simcityacademy.ui.bimester.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.simcityacademy.domain.model.BimesterModel
import br.com.zup.simcityacademy.domain.usecase.BimesterUseCase

class BimesterViewModel:ViewModel() {
    private val repository = BimesterUseCase()
    private val _response: MutableLiveData<List<BimesterModel>> = MutableLiveData()
    val response: LiveData<List<BimesterModel>> = _response

    private fun getAllGrade() {
        try {
            _response.value = repository.getListGrades()
        } catch (ex: Exception) {
            Log.i("Error", "------> ${ex.message}")
        }
    }
    fun addGrade(bimester1: BimesterModel){
        try {
            repository.addGradeList(bimester1)
            getAllGrade()
        } catch (ex: Exception) {
            Log.i("Error", "------> ${ex.message}")
        }
    }
}