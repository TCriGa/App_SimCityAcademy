package br.com.zup.simcityacademy.ui.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.simcityacademy.databinding.FragmentHomeBinding
import br.com.zup.simcityacademy.ui.home.view.pageradapter.HomePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val titlesList = listOf("1º Bim", "2º Bim", "3º Bim", "4º Bim")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPagerTabLayout()
    }
    private fun setViewPagerTabLayout() {
        val homePagerAdapter =
            HomePagerAdapter((activity as HomeActivity).supportFragmentManager, lifecycle, titlesList)
        binding.vpInformacoes.adapter = homePagerAdapter

        TabLayoutMediator(binding.tlInformacoes, binding.vpInformacoes) { tab, posicao ->
            tab.text = titlesList[posicao]
        }.attach()
    }

}