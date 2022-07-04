package br.com.zup.simcityacademy.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BimesterModel(
    val matter: String,
    val grade: Double
) : Parcelable