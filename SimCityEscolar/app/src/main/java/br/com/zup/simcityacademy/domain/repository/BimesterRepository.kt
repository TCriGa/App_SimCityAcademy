package br.com.zup.simcityacademy.domain.repository

import br.com.zup.simcityacademy.data.datasource.local.dao.BimesterDAO
import br.com.zup.simcityacademy.domain.model.Bimester

class BimesterRepository(private val bimesterDAO: BimesterDAO) {

    suspend fun getAllgrade(): List<Bimester> = bimesterDAO.getAllGrade()

    suspend fun insertInformations(bimester: Bimester){
        bimesterDAO.insertGrade(bimester)
    }
}