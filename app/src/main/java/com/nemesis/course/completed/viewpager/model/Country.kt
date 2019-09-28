package com.nemesis.course.completed.viewpager.model

import android.content.Context
import android.support.annotation.DrawableRes
import com.nemesis.course.completed.viewpager.R

class Country{

    var name:String = ""

    @DrawableRes
    var flag:Int = 0

    companion object{

        fun loadCountries(context: Context): ArrayList<Country>{

            val array = ArrayList<Country>()

            val country01 = Country()
            country01.name = context.getString(R.string.country_01)
            country01.flag = R.drawable.country_01
            array.add(country01)

            val country02 = Country()
            country02.name = context.getString(R.string.country_02)
            country02.flag = R.drawable.country_02
            array.add(country02)

            val country03 = Country()
            country03.name = context.getString(R.string.country_03)
            country03.flag = R.drawable.country_03
            array.add(country03)

            val country04 = Country()
            country04.name = context.getString(R.string.country_04)
            country04.flag = R.drawable.country_04
            array.add(country04)

            val country05 = Country()
            country05.name = context.getString(R.string.country_05)
            country05.flag = R.drawable.country_05
            array.add(country05)

            val country06 = Country()
            country06.name = context.getString(R.string.country_06)
            country06.flag = R.drawable.country_06
            array.add(country06)

            val country07 = Country()
            country07.name = context.getString(R.string.country_07)
            country07.flag = R.drawable.country_07
            array.add(country07)

            val country08 = Country()
            country08.name = context.getString(R.string.country_08)
            country08.flag = R.drawable.country_08
            array.add(country08)

            return array
        }

    }

}