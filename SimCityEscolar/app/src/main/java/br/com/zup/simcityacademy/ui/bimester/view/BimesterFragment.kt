package br.com.zup.simcityacademy.ui.bimester.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.databinding.FragmentBimesterBinding
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.ui.bimester.view.adapter1.BimesterAdapter
import br.com.zup.simcityacademy.ui.bimester.viewmodel.BimesterViewModel
import br.com.zup.simcityacademy.ui.viewstate.ViewState

class BimesterFragment : Fragment() {
    private lateinit var binding: FragmentBimesterBinding
    var type: Int = 1

    companion object {
        fun newInstance(type: Int): BimesterFragment {
            return BimesterFragment().apply {
                this.type = type
            }
        }
    }

    private val listNotesAdapter: BimesterAdapter by lazy {
        BimesterAdapter(arrayListOf(), this::goEditBimester)
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
        initObserver()
        clickButtonAdd()
    }

    private fun clickButtonAdd() {
        binding.buttonAdicionarNotas.setOnClickListener {
            if (verifierDadsInserts()) {
                viewModel.insertBimester(
                    Bimester(
                        matter = binding.spMateria.selectedItem.toString(),
                        grade = binding.editNota.text.toString().toFloat(),
                        bimesterNumber = type
                    )
                )
                clearEditFields()
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

    private fun verifierDadsEdit(): Boolean {
        when {

            binding.editNotaEdit.text?.isEmpty() == true -> {
                binding.editNota.error = MENSAGEM_ERRO_NOTA
                return false
            }
        }
        return true
    }


    private fun clearEditFields() {
        binding.editNota.text?.clear()
    }

    private fun initObserver() {
        viewModel.viewState.bimester.observe(this.viewLifecycleOwner){
            listNotesAdapter.updateListGrade(it)
        }
    }

    private fun goEditBimester(bimester: Bimester) {
        enableEditMode(bimester)
    }

    private fun enableEditMode(bimester: Bimester) {
        binding.editNotaEdit.visibility = View.VISIBLE
        binding.buttonAdicionarNotasEdit.visibility = View.VISIBLE
        binding.buttonAdicionarNotasEdit.setOnClickListener {
            bimester.grade= binding.editNotaEdit.text.toString().toFloat()
            if (verifierDadsEdit()) {
                viewModel.updateBimester(bimester)
                clearEditFields()
                enableSaveRegisterMode()
            }
        }
    }

    private fun enableSaveRegisterMode() {
        binding.editNotaEdit.visibility = View.GONE
        binding.buttonAdicionarNotasEdit.visibility = View.GONE
    }
}