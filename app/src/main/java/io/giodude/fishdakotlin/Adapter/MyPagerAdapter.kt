package io.giodude.fishdakotlin.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.giodude.fishdakotlin.View.BonusView
import io.giodude.fishdakotlin.View.HomeView
import io.giodude.fishdakotlin.View.ItemView
import io.giodude.fishdakotlin.View.TipsView

internal class MyPagerAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position){

            0 -> {
                HomeView()
            }
            1 -> {
                ItemView()
            }
            2 -> {
                TipsView()
            }
            3 -> {
                BonusView()
            }
//            4 -> {
//                PromoFragment()
//            }
            else -> getItem(position)

        }
    }

}