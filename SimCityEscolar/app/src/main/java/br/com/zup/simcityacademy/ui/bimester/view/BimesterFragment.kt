package br.com.zup.simcityacademy.ui.bimester.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.databinding.FragmentBimesterBinding

import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.ui.bimester.view.adapter1.BimesterAdapter
import br.com.zup.simcityacademy.ui.bimester.viewmodel.BimesterViewModel

class BimesterFragment : Fragment() {
    private lateinit var binding: FragmentBimesterBinding

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
        binding = FragmentBimesterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        exhibitRecycleView()
        observable()
        clickButtonAdd()
    }

    private fun observable() {
        viewModel1.response.observe(this.viewLifecycleOwner) {
            listNotesAdapter.atualizarListaAlbum(it as MutableList<Bimester>)
        }
    }

    private fun clickButtonAdd() {
        binding.buttonAdicionarNotas.setOnClickListener {
            if (!verifierDadsInserts()){
                val grade = Bimester(
                    binding.spMateria.selectedItem.toString(),
                    binding.editNota.text.toString().toDouble()
                )
                viewModel1.addGrade(grade)
            }

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