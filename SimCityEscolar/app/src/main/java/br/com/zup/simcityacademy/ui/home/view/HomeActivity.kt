package br.com.zup.simcityacademy.ui.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import br.com.zup.simcityacademy.R
import br.com.zup.simcityacademy.databinding.ActivityHomeBinding
import br.com.zup.simcityacademy.ui.home.view.pageradapter.HomePagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val titlesList = listOf("1º Bim", "2º Bim", "3º Bim", "4º Bim")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exhibitViewPagerTabLayout()
    }

    private fun exhibitViewPagerTabLayout() {
        val homePagerAdapter =
            HomePagerAdapter(supportFragmentManager, lifecycle, titlesList)
        binding.vpInformacoes.adapter = homePagerAdapter

        TabLayoutMediator(binding.tlInformacoes, binding.vpInformacoes) { tab, posicao ->
            tab.text = titlesList[posicao]
        }.attach()
    }
}