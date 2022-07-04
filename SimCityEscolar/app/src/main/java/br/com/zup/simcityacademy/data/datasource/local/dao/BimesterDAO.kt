package br.com.zup.simcityacademy.data.datasource.local.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.simcityacademy.domain.model.Bimester

interface BimesterDAO {

    @Query("SELECT *FROM `informacoes_bimestre` WHERE matter")
    fun getAllMatter(Allmatter : String) :List<Bimester>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatter(bimester: Bimester)
}
