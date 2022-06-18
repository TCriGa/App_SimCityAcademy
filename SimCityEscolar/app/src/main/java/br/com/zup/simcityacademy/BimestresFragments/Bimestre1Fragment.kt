package br.com.zup.simcityacademy.BimestresFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.zup.simcityacademy.databinding.FragmentBimestre1Binding

class Bimestre1Fragment : Fragment() {
private lateinit var binding: FragmentBimestre1Binding
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBimestre1Binding.inflate(inflater,container, false)
        return binding.root
    }

}