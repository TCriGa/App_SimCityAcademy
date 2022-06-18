package br.com.zup.simcityacademy.bimestresFragments.bimestre1.adapterBimestre1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcityacademy.databinding.ListaNotasItemBinding
import br.com.zup.simcityacademy.model.Aluno

class Bimestre1Adapter(
    private var listaNotas: MutableList<Aluno>

) : RecyclerView.Adapter<Bimestre1Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ListaNotasItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val aluno = listaNotas[position]
        holder.exibirListaNotas(aluno)
    }

    override fun getItemCount(): Int = listaNotas.size

    fun atualizarListaAlbum(novaLista: MutableList<Aluno>) {
        if (novaLista.size == 0) {
            listaNotas = novaLista
        } else {
            listaNotas.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ListaNotasItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exibirListaNotas(aluno: Aluno) {
            binding.textNota.text = aluno.getNota().toString()
            binding.textMateria.text = aluno.getMateria()

        }
    }

}