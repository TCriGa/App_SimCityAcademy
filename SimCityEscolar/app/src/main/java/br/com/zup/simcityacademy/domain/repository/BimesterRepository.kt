package br.com.zup.simcityacademy.domain.repository

import br.com.zup.simcityacademy.data.datasource.local.dao.BimesterDAO
import br.com.zup.simcityacademy.domain.model.Bimester

class BimesterRepository(private val bimesterDAO: BimesterDAO) {

    suspend fun insertBimester(bimester: Bimester) {
        bimesterDAO.insertBimester(bimester)
    }

    suspend fun getBimester(bimesterNumber: Int): List<Bimester> =
        bimesterDAO.getBimesterByNumber(bimesterNumber)
}