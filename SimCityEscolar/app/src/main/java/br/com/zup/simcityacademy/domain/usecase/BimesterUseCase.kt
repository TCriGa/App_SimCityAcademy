package br.com.zup.simcityacademy.domain.usecase

import android.app.Application
import br.com.zup.simcityacademy.domain.model.Bimester

class BimesterUseCase() {
    private val listGradesBimesters = mutableListOf<Bimester>()

    fun getListGrades() : MutableList<Bimester> {
        return listGradesBimesters
    }

    fun addGradeList(bimester1: Bimester){

        listGradesBimesters.add(bimester1)
    }

}
