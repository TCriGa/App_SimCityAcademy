package br.com.zup.simcityacademy.data.datasource.local.dao

import androidx.room.*
import br.com.zup.simcityacademy.domain.model.Bimester

@Dao
interface BimesterDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertBimester(bimester: Bimester)

    @Query("SELECT * FROM information_bimester WHERE bimester_number =:bimesterNumber")
    fun getBimesterByNumber(bimesterNumber: Int): List<Bimester>

    @Query("SELECT AVG(grade) FROM information_bimester WHERE grade =:gradeBimester")
    fun getGrade(gradeBimester: Float) : Float

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGrades(grade: Bimester)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateAVGGrade(bimester: Bimester)
}
