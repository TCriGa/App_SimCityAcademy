package br.com.zup.simcityacademy.bimestresFragments.bimestre1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcityacademy.bimestresFragments.bimestre1.adapterBimestre1.Bimestre1Adapter
import br.com.zup.simcityacademy.MENSAGEM_ERRO_MATERIA
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOME_ALUNO
import br.com.zup.simcityacademy.MENSAGEM_ERRO_NOTA
import br.com.zup.simcityacademy.databinding.FragmentBimestre1Binding
import br.com.zup.simcityacademy.model.Aluno

class Bimestre1Fragment : Fragment() {
    private lateinit var binding: FragmentBimestre1Binding
    private lateinit var nomeAluno: String
    private lateinit var materia: String
    private lateinit var nota: String

    private val listNotesAdapter: Bimestre1Adapter by lazy {
        Bimestre1Adapter(arrayListOf())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBimestre1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickButtonAdd()
    }

    private fun additionalItemListAluino() {
        val listaNotasAluno = mutableListOf<Aluno>()
        recuperateDadsAluino()
        if (!verifierDadsInserts()) {
            val aluno = Aluno(nomeAluno, materia, nota.toDouble())
            listaNotasAluno.add(aluno)
            listNotesAdapter.atualizarListaAlbum(listaNotasAluno)
            exhibitRecycleView()
        }
    }

    private fun clickButtonAdd() {
        binding.buttonAdicionarNotas.setOnClickListener {
            additionalItemListAluino()
            limperCamposEdict()
        }
    }

    private fun exhibitRecycleView() {
        binding.rvListaNotas.adapter = listNotesAdapter
    }

    private fun recuperateDadsAluino() {
        this.nomeAluno = binding.editNomeAluno.text.toString()
        this.materia = binding.editMateria.text.toString()
        this.nota = binding.editNota.text.toString()
    }

    private fun verifierDadsInserts(): Boolean {
        when {
            this.nomeAluno.isEmpty() -> {
                binding.editNomeAluno.error = MENSAGEM_ERRO_NOME_ALUNO
                return true
            }
            this.materia.isEmpty() -> {
                binding.editMateria.error = MENSAGEM_ERRO_MATERIA
                return true
            }
            this.nota.isEmpty() -> {
                binding.editNota.error = MENSAGEM_ERRO_NOTA
                return true
            }
        }
        return false
    }

    private fun limperCamposEdict() {
        binding.editNota.text?.clear()
        binding.editMateria.text?.clear()
        binding.editNomeAluno.text?.clear()
    }
}