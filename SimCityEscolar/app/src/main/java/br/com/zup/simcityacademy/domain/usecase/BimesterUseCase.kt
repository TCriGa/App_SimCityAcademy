package br.com.zup.simcityacademy.domain.usecase

import android.app.Application
import br.com.zup.simcityacademy.data.datasource.local.BimesterDataBase
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.domain.repository.BimesterRepository

class BimesterUseCase(application: Application) {
    private val bimesterDAO = BimesterDataBase.getDataBase(application).bimesterDAO()
    private val bimesterRepository = BimesterRepository(bimesterDAO)

    suspend fun getBimester(): List<Bimester> {
        return bimesterRepository.getBimester()
    }
    suspend fun insertBimester(bimester: Bimester) {
       bimesterRepository.insertBimester(bimester)
    }
}

