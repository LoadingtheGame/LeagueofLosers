package com.example.wineryfactory.Model

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.wineryfactory.R
import com.example.wineryfactory.View.*

private val TAB_TITLES = arrayOf(
        R.string.tab_text_1,
        R.string.tab_text_3,
        R.string.tab_text_2,
        R.string.tab_text_4

)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return PlaceholderFragment.newInstance(position + 1)
        } else if (position == 1) {
            return tela_jogos.newInstance(position + 1)
        } else if (position == 2) {
            return tela_times.newInstance(position + 1)
        } else {
            return tela_jogadores.newInstance(position + 1)
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 4 total pages.
        return 4
    }
}