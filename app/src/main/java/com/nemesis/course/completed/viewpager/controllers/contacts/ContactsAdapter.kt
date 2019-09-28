package com.nemesis.course.completed.viewpager.controllers.contacts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nemesis.course.completed.viewpager.R
import com.nemesis.course.completed.viewpager.model.Contact

interface ContactsListener{
    fun onContactSelected(contact: Contact)
    fun onCall(contact: Contact)
    fun onEmail(contact: Contact)
}

class ContactsAdapter(val contacts: ArrayList<Contact>, var listener: ContactsListener): RecyclerView.Adapter<ContactViewHolder>() {



    //Cuantos elementos tiene la lista
    override fun getItemCount(): Int {
        return contacts.size
    }

    //Configurar el ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_contact, parent, false)
        val viewHolder = ContactViewHolder(view)
        return viewHolder
    }

    //Mostramos datos
    override fun onBindViewHolder(viewHolder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        viewHolder.bindData(contact, listener)
    }


}