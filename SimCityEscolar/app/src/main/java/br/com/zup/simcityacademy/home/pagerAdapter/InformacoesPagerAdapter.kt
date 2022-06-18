package br.com.zup.simcityacademy.home.pagerAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.simcityacademy.bimestresFragments.bimestre1.Bimestre1Fragment
import br.com.zup.simcityacademy.bimestresFragments.bimestre2.Bimestre2Fragment

class InformacoesPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var listanotas: List<String>

) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listanotas.size

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return Bimestre1Fragment()
            1 -> return Bimestre2Fragment()

        }
        return Bimestre1Fragment()
    }
}