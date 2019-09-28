package com.nemesis.course.completed.viewpager.controllers.kitties

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import com.nemesis.course.completed.viewpager.R
import com.nemesis.course.completed.viewpager.model.Kitty
import com.nemesis.course.completed.viewpager.model.io.ConnectionManager

class KittiesFragment: Fragment() {

    private lateinit var gridView: GridView
    private lateinit var adapter: KittiesAdapter
    private var kitties = ArrayList<Kitty>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_kitties, container, false)

        gridView = view.findViewById(R.id.gridview)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        setupFragment()
        loadKitties()
    }

    private fun setupFragment(){
        adapter =
            KittiesAdapter(activity!!, R.layout.item_kitty, kitties)
        gridView.adapter = adapter
    }

    private fun loadKitties(){
        ConnectionManager.loadKitties(success = { items ->

            kitties.clear()
            kitties.addAll(items)
            adapter.notifyDataSetChanged()

        }, fail = { error ->

            Toast.makeText(activity!!, error, Toast.LENGTH_SHORT).show()

        })
    }

}