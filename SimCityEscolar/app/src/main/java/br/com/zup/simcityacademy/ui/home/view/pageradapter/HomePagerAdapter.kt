package br.com.zup.simcityacademy.ui.home.view.pageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.zup.simcityacademy.ui.bimester.view.BimesterFragment

class HomePagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private var listanotas: List<String>

) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = listanotas.size

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return BimesterFragment.newInstance(1)
            1 -> return BimesterFragment.newInstance(2)
            2 -> return BimesterFragment.newInstance(3)
            3 -> return BimesterFragment.newInstance(4)

        }
        return BimesterFragment()
    }
}