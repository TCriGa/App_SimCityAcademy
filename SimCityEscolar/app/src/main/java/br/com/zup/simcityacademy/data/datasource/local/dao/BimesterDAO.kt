package br.com.zup.simcityacademy.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.zup.simcityacademy.domain.model.Bimester

@Dao
interface BimesterDAO {

    @Query("SELECT * FROM information_bimester ORDER BY matter ASC")
    fun getBimester(): List<Bimester>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBimester(bimester: Bimester)

    @Query("SELECT * FROM information_bimester WHERE bimester_number =:bimesterNumber")
    fun getBimesterByNumber(bimesterNumber: Int): List<Bimester>

}
