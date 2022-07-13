package br.com.zup.simcityacademy.domain.usecase

import android.app.Application
import android.view.View
import br.com.zup.simcityacademy.data.datasource.local.BimesterDataBase
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.repository.BimesterRepository
import br.com.zup.simcityacademy.ui.viewstate.ViewState

class BimesterUseCase(application: Application) {
    private val bimesterDAO = BimesterDataBase.getDataBase(application).bimesterDAO()
    private val bimesterRepository = BimesterRepository(bimesterDAO)

    suspend fun getBimester(bimesterNumber: Int): List<Bimester> {
        return bimesterRepository.getBimester(bimesterNumber)
    }
    suspend fun insertBimester(bimester: Bimester) {
        bimester.bimesterNumber?.let { getBimester(it) }
       bimesterRepository.insertBimester(bimester)
    }

    suspend fun updateGrades(bimester: Bimester) = bimesterRepository.updateAVGGrade(bimester)

}

