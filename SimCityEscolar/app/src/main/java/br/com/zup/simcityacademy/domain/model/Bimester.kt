package br.com.zup.simcityacademy.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "Informacoes_bimestre")
data class Bimester(

    @PrimaryKey
    @ColumnInfo
    val matter: String,

    @ColumnInfo
    val grade: Double
) : Parcelable