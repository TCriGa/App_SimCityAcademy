package br.com.zup.simcityacademy.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Information_bimester")
data class Bimester(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id : Int? = null,

    @ColumnInfo(name = "matter")
    var matter: String? = null,

    @ColumnInfo(name = "grade")
    var grade: Float? = null,

    @ColumnInfo(name = "bimester_number")
    var bimesterNumber: Int? = null
) : Parcelable