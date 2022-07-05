package br.com.zup.simcityacademy.domain.usecase

import android.app.Application
import br.com.zup.simcityacademy.data.datasource.local.BimesterDataBase
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.repository.BimesterRepository
import br.com.zup.simcityacademy.ui.viewstate.ViewState

class BimesterUseCase(application: Application) {
    private val bimesterDAO = BimesterDataBase.getDataBase(application).bimesterDAO()
    private val bimesterRepository = BimesterRepository(bimesterDAO)

    suspend fun getAllInformation(): List<Bimester> {
        return bimesterRepository.getAllgrade()
    }
    suspend fun insertAllInformation(bimester: Bimester) {
       return  bimesterRepository.insertInformations(bimester)
    }
}

