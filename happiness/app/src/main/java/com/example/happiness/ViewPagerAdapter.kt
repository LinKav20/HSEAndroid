package com.example.happiness

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.happiness.activities.FragmentCardActivity
import java.util.*

class ViewPagerAdapter(fm: FragmentManager, installation: Date) : FragmentStatePagerAdapter(fm) {

    val installed = installation

    override fun getItem(position: Int): Fragment {
        val difference = ((Date().getTime() - installed.getTime()) / (1000 * 60 * 60 * 24)).toInt()
        Log.d("INSTALLED DIFFERENCE", difference.toString() + " " + position.toString())

        return  if (position < difference + 10) FragmentCardActivity.newInstance(position) else {
            FragmentCardActivity.newInstance(-1)
        }
    }

    override fun getCount(): Int {
        return 40
    }
}
