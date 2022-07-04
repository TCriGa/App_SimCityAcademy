package br.com.zup.simcityacademy.domain.usecase

import br.com.zup.simcityacademy.domain.model.BimesterModel

class BimesterUseCase {
    private val listGradesBimesterModels = mutableListOf<BimesterModel>()

    fun getListGrades() : MutableList<BimesterModel> {
        return listGradesBimesterModels
    }

    fun addGradeList(bimester1: BimesterModel){

        listGradesBimesterModels.add(bimester1)
    }

}
