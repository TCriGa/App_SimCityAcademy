package br.com.zup.simcityacademy.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Aluno(
    private val nomeAluno: String,
    private val materia: String,
    private val nota: Double
) : Parcelable {
    fun getNomeAluno() = this.nomeAluno
    fun getMateria() = this.materia
    fun getNota() = this.nota
}