package br.com.zup.simcityacademy.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.simcityacademy.domain.model.Bimester

@Dao
interface BimesterDAO {

    @Query("SELECT *FROM `informacoes_bimestre` WHERE matter")
    fun getAllMatter() :List<Bimester>

    @Query("SELECT *FROM `informacoes_bimestre` WHERE grade")
    fun getAllGrade() :List<Bimester>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMatter(bimester: Bimester)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGrade(bimester: Bimester)
}
