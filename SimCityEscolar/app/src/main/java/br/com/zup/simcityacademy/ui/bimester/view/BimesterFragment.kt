package br.com.zup.simcityacademy.ui.bimester.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.databinding.FragmentBimesterBinding
import br.com.zup.simcityacademy.domain.model.Bimester

import br.com.zup.simcityacademy.ui.bimester.view.adapter1.BimesterAdapter
import br.com.zup.simcityacademy.ui.bimester.viewmodel.BimesterViewModel
import br.com.zup.simcityacademy.ui.viewstate.ViewState
import br.com.zup.simcityacademy.ui.viewstate.ViewState.State.*

class BimesterFragment : Fragment() {
    private lateinit var binding: FragmentBimesterBinding
    var type: Int? = null

    companion object {
        fun newInstance(type: Int): BimesterFragment {
            return BimesterFragment().apply {
                this.type = type
            }
        }
    }

    private val listNotesAdapter: BimesterAdapter by lazy {
        BimesterAdapter(arrayListOf())
    }

    private val viewModel: BimesterViewModel by lazy {
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
        initiObserver()
        clickButtonAdd()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun clickButtonAdd() {
        binding.buttonAdicionarNotas.setOnClickListener {
            if (verifierDadsInserts()) {
                viewModel.insertInformations(
                    Bimester(
                        binding.spMateria.selectedItem.toString(),
                        binding.editNota.text.toString().toDouble()
                    )
                )

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

    private fun initiObserver() {
        viewModel.getInformation()
        viewModel.viewState.bimester.observe(this.viewLifecycleOwner) {
            listNotesAdapter.updateListGrade(it)
        }
        viewModel.viewState.state.observe(this.viewLifecycleOwner) {
//            when (it) {
//                SUCCESS ->  Toast.makeText(context, "Nota cadastrada com sucesso", Toast.LENGTH_LONG)
//                    .show()
//                ERROR ->  Toast.makeText(context,"Erro desconhecido", Toast.LENGTH_LONG)
//                    .show()
//            }
        }
    }
}

