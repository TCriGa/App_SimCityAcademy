package br.com.zup.simcityacademy.ui.bimester.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcityacademy.BIMESTER_KEY
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.R
import br.com.zup.simcityacademy.databinding.FragmentBimesterBinding
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.ui.bimester.view.adapter1.BimesterAdapter
import br.com.zup.simcityacademy.ui.bimester.viewmodel.BimesterViewModel

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
        setRecycleView()
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

    private fun setRecycleView() {
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

    private fun initObserver() {
        viewModel.viewState.bimester.observe(this.viewLifecycleOwner) {
            listNotesAdapter.updateListGrade(it)
        }
    }

    private fun goEditBimester(bimester: Bimester) {
        val bundle = bundleOf(BIMESTER_KEY to bimester)
        NavHostFragment.findNavController(this)
            .navigate(R.id.action_homeFragment_to_bimesterEditFragment, bundle)
    }


}