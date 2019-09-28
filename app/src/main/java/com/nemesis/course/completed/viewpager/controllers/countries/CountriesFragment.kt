package com.nemesis.course.completed.viewpager.controllers.countries

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import com.nemesis.course.completed.viewpager.R
import com.nemesis.course.completed.viewpager.model.Country

class CountriesFragment: Fragment(), CountriesListener {

    private lateinit var listView: ListView
    private lateinit var adapter: CountriesAdapter
    private var countries = ArrayList<Country>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_countries, container, false)

        listView = view.findViewById(R.id.countries_listview)

        return view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        setupFragment()
    }

    override fun onCountrySelected(country: Country) {
        Toast.makeText(activity!!, country.name, Toast.LENGTH_SHORT).show()
    }

    fun setupFragment(){
        adapter = CountriesAdapter(
            activity!!,
            countries,
            R.layout.item_country
        )
        adapter.listener = this

        listView.adapter = adapter

        loadCountries()
    }

    fun loadCountries(){
        val array = Country.loadCountries(activity!!)

        countries.clear()
        countries.addAll(array)

        adapter.notifyDataSetChanged()
    }
}