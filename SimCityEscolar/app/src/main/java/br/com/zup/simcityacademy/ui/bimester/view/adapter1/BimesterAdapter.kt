package br.com.zup.simcityacademy.ui.bimester.view.adapter1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.simcityacademy.databinding.GradeListItemBinding
import br.com.zup.simcityacademy.domain.model.Bimester

class BimesterAdapter(
    private var gradeList: MutableList<Bimester>

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

    fun updateListGrade(newList: List<Bimester>) {
        if (gradeList.size == 0) {
            gradeList = newList as MutableList<Bimester>
        } else {
            gradeList.addAll(newList)
        }
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: GradeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun exhibitGradeList(bimester: Bimester) {
            binding.textGrade.text = bimester.grade.toString()
            binding.textMatter.text = bimester.matter

        }
    }
}