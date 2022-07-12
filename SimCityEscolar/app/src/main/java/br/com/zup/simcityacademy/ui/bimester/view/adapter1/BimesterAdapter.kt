package br.com.zup.simcityacademy.ui.bimester.view.adapter1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.PrimaryKey
import br.com.zup.simcityacademy.databinding.GradeListItemBinding
import br.com.zup.simcityacademy.domain.model.Bimester
import kotlin.reflect.KFunction1

class BimesterAdapter(
    private var gradeList: MutableList<Bimester>,
    private val clickBimester:(MutableList: Bimester) -> Unit
) : RecyclerView.Adapter<BimesterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            GradeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = gradeList[position]
        holder.exhibitGradeList(student)
        holder.binding.cardVListaNotasItem.setOnClickListener {
            clickBimester(student)
        }
    }

    override fun getItemCount(): Int = gradeList.size

    fun updateListGrade(newList: List<Bimester>) {
        gradeList = newList as MutableList<Bimester>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: GradeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun exhibitGradeList(bimester: Bimester) {
            binding.textGrade.text = bimester.grade.toString()
            binding.textMatter.text = bimester.matter

        }
    }
}