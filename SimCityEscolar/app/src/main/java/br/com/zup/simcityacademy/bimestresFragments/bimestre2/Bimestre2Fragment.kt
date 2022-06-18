package br.com.zup.simcityacademy.bimestresFragments.bimestre2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcityacademy.databinding.FragmentBimestre2Binding

class Bimestre2Fragment : Fragment() {
private lateinit var binding: FragmentBimestre2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentBimestre2Binding.inflate(inflater,container, false)
        return binding.root
    }

}