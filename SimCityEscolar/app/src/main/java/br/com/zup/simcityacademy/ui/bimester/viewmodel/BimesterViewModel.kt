package br.com.zup.simcityacademy.ui.bimester.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.usecase.BimesterUseCase

class BimesterViewModel:ViewModel() {
    private val repository = BimesterUseCase()
    private val _response: MutableLiveData<List<Bimester>> = MutableLiveData()
    val response: LiveData<List<Bimester>> = _response

    private fun getAllGrade() {
        try {
            _response.value = repository.getListGrades()
        } catch (ex: Exception) {
            Log.i("Error", "------> ${ex.message}")
        }
    }
    fun addGrade(bimester1: Bimester){
        try {
            repository.addGradeList(bimester1)
            getAllGrade()
        } catch (ex: Exception) {
            Log.i("Error", "------> ${ex.message}")
        }
    }
}