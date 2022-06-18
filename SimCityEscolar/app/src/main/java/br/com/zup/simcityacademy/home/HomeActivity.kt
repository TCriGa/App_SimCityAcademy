package br.com.zup.simcityacademy.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import br.com.zup.simcityacademy.R
import br.com.zup.simcityacademy.databinding.ActivityHomeBinding
import br.com.zup.simcityacademy.home.pagerAdapter.InformacoesPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val listaTitulos = listOf("1º Bimestre", "2º Bimentre")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirViewPagerTabLayout()
    }

    private fun exibirViewPagerTabLayout() {
        val informacoesPagerAdapter =
            InformacoesPagerAdapter(supportFragmentManager, lifecycle, listaTitulos)
        binding.vpInformacoes.adapter = informacoesPagerAdapter

        TabLayoutMediator(binding.tlInformacoes, binding.vpInformacoes) { tab, posicao ->
            tab.text = listaTitulos[posicao]
        }.attach()
    }
}