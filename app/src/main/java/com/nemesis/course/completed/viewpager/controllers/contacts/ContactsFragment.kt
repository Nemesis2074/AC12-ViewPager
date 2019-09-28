package com.nemesis.course.completed.viewpager.controllers.contacts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.nemesis.course.completed.viewpager.R
import com.nemesis.course.completed.viewpager.model.Contact
import com.nemesis.course.completed.viewpager.model.io.ConnectionManager

class ContactsFragment: Fragment(), ContactsListener {

    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactsAdapter
    private var contacts = ArrayList<Contact>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val view = inflater.inflate(R.layout.fragment_contacts, container, false)

        refreshLayout = view.findViewById(R.id.refresh_layout)
        recyclerView = view.findViewById(R.id.contacts_recyclerview)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        retainInstance = true
        setupFragment()
        loadContacts()
    }

    override fun onContactSelected(contact: Contact) {
        Toast.makeText(activity!!, contact.name, Toast.LENGTH_SHORT).show()
    }

    override fun onCall(contact: Contact) {
        val data = Uri.fromParts("tel", contact.phone, null)

        val intent = Intent(Intent.ACTION_DIAL, data)
        intent.setData(data)

        val chooser = Intent.createChooser(intent, "Seleccionar")
        startActivity(chooser)
    }

    override fun onEmail(contact: Contact) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, "mensaje de prueba")
        intent.putExtra(Intent.EXTRA_SUBJECT, contact.email)
        intent.type = "text/plain"


        val chooser = Intent.createChooser(intent, "Seleccionar")
        startActivity(chooser)
    }

    private fun setupFragment(){

        adapter = ContactsAdapter(contacts, this)

        val layoutManager = LinearLayoutManager(activity!!, LinearLayoutManager.VERTICAL, false)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        refreshLayout.setOnRefreshListener {
            loadContacts()
        }
    }


    private fun loadContacts(){

        ConnectionManager.requestContacts(success = {

            contacts.clear()
            contacts.addAll(it)
            adapter.notifyDataSetChanged()
            refreshLayout.isRefreshing = false

        }, fail = {
            refreshLayout.isRefreshing = false
        })
    }

}