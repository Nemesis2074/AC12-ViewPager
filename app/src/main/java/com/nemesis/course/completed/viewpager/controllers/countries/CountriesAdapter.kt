package com.nemesis.course.completed.viewpager.controllers.countries

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nemesis.course.completed.viewpager.R
import com.nemesis.course.completed.viewpager.model.Country

interface CountriesListener{
    fun onCountrySelected(country: Country)
}

class CountriesAdapter(context: Context, countries:ArrayList<Country>, itemRes:Int): ArrayAdapter<Country>(context, itemRes, countries){

    var listener: CountriesListener? = null

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view = convertView
        if(view == null){

            val inflater = LayoutInflater.from(parent.context)
            view = inflater.inflate(R.layout.item_country, parent, false)
        }

        val country = getItem(position)

        if(view != null && country != null){

            val imgFlag: ImageView = view.findViewById(R.id.country_flag)
            val txtName: TextView = view.findViewById(R.id.country_name)

            imgFlag.setImageResource(country.flag)
            txtName.text = country.name

            view.setOnClickListener {
                listener?.onCountrySelected(country)
            }

        }

        return view!!

    }

}