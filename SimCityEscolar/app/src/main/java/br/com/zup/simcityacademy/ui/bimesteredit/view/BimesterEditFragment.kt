package br.com.zup.simcityacademy.ui.bimesteredit.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.databinding.FragmentBimesterEditBinding
import br.com.zup.simcityacademy.domain.model.Bimester
import br.com.zup.simcityacademy.ui.bimesteredit.viewmodel.BimesterEditViewModel

class BimesterEditFragment : Fragment() {

    private lateinit var binding : FragmentBimesterEditBinding

    private val viewModel: BimesterEditViewModel by lazy {
        ViewModelProvider(this)[BimesterEditViewModel::class.java]
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentBimesterEditBinding.inflate(inflater,container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bimester = Bimester()
        enableEditMode(bimester)
    }

    private fun verifierDadsEdit(): Boolean {
        when {
            binding.editNotaEdit.text?.isEmpty() == true -> {
                binding.editNotaEdit.error = MENSAGEM_ERRO_NOTA
                return false
            }
        }
        return true
    }

    private fun enableEditMode(bimester: Bimester) {
        binding.editNotaEdit.visibility = View.VISIBLE
        binding.buttonAdicionarNotasEdit.visibility = View.VISIBLE
        binding.buttonAdicionarNotasEdit.setOnClickListener {
            if (verifierDadsEdit()){
                viewModel.updateBimester(bimester)
                bimester.grade = binding.editNotaEdit.text.toString().toFloat()
                enableSaveRegisterMode()
            }
        }
    }

    private fun enableSaveRegisterMode() {
        binding.editNotaEdit.visibility = View.GONE
        binding.buttonAdicionarNotasEdit.visibility = View.GONE
    }
}