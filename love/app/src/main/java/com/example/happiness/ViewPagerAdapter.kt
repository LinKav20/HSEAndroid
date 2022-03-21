package com.example.happiness

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.happiness.activities.FragmentCardActivity

class ViewPagerAdapter(fm: FragmentManager, cc: CardController) : FragmentStatePagerAdapter(fm) {
    private val cards = cc

    override fun getItem(position: Int): Fragment {
        return FragmentCardActivity.newInstance(cards[position])
    }

    override fun getCount(): Int {
        return cards.getCount()
    }
}