package br.com.zup.simcityacademy.ui.bimester.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.databinding.FragmentBimester1Binding
import br.com.zup.simcityacademy.domain.model.BimesterModel
import br.com.zup.simcityacademy.ui.bimester.view.adapter1.BimesterAdapter
import br.com.zup.simcityacademy.ui.bimester.viewmodel.BimesterViewModel

class BimesterFragment : Fragment() {
    private lateinit var binding: FragmentBimester1Binding

    private val listNotesAdapter: BimesterAdapter by lazy {
        BimesterAdapter(arrayListOf())
    }

    private val viewModel1: BimesterViewModel by lazy {
        ViewModelProvider(this)[BimesterViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBimester1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exhibitRecycleView()
        observable()
        verifierDadsInserts()
        clickButtonAdd()
    }

    private fun observable() {
        viewModel1.response.observe(this.viewLifecycleOwner) {
            listNotesAdapter.atualizarListaAlbum(it as MutableList<BimesterModel>)
        }
    }

    private fun clickButtonAdd() {
        binding.buttonAdicionarNotas.setOnClickListener {
            val grade = BimesterModel(
                binding.spMateria.selectedItem.toString(),
                binding.editNota.text.toString().toDouble()
            )
            viewModel1.addGrade(grade)
        }
    }

    private fun exhibitRecycleView() {
        binding.rvListaNotas.adapter = listNotesAdapter

    }

    private fun verifierDadsInserts(): Boolean {
        when {

            binding.editNota.text?.isEmpty() == true -> {
                binding.editNota.error = MENSAGEM_ERRO_NOTA
                return false
            }
        }
        return true
    }

    private fun clearEditFields() {
        binding.editNota.text?.clear()
    }
}