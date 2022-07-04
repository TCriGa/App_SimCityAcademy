package br.com.zup.simcityacademy.ui.bimester.view.adapter1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcityacademy.databinding.GradeListItemBinding
import br.com.zup.simcityacademy.domain.model.BimesterModel

class BimesterAdapter(
    private var gradeList: MutableList<BimesterModel>

) : RecyclerView.Adapter<BimesterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            GradeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = gradeList[position]
        holder.exhibitGradeList(student)
    }

    override fun getItemCount(): Int = gradeList.size


    fun atualizarListaAlbum(novaLista : MutableList<BimesterModel>){
        if (gradeList.size == 0){
            gradeList = novaLista
        }else{
            gradeList.addAll(novaLista)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: GradeListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun exhibitGradeList(bimesterModel: BimesterModel) {
            binding.textGrade.text = bimesterModel.grade.toString()
            binding.textMatter.text = bimesterModel.matter

        }
    }

}