package com.nemesis.course.completed.viewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.nemesis.course.completed.viewpager.controllers.contacts.ContactsFragment
import com.nemesis.course.completed.viewpager.controllers.countries.CountriesFragment
import com.nemesis.course.completed.viewpager.controllers.kitties.KittiesFragment

class PagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> {
                CountriesFragment()
            }
            1 -> {
                KittiesFragment()
            }
            2 -> {
                ContactsFragment()
            }
            else -> {
                CountriesFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }


}