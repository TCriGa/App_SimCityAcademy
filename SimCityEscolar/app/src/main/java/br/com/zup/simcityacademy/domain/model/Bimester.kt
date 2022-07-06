package br.com.zup.simcityacademy.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Informacoes_bimestre")
data class Bimester(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id : Int =1,

    @ColumnInfo(name = "matter")
    var matter: String,

    @ColumnInfo(name = "grade")
    var grade: Double
) : Parcelable