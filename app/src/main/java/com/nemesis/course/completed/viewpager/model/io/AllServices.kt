package com.nemesis.course.completed.viewpager.model.io

import com.nemesis.course.completed.viewpager.model.Contact
import com.nemesis.course.completed.viewpager.model.Kitty
import retrofit2.Call
import retrofit2.http.GET

interface AllServices{

    @GET("/demos/kitties.json")
    fun loadKitties(): Call<ArrayList<Kitty>>

    @GET("/demos/contacts.json")
    fun loadContacts(): Call< ArrayList<Contact> >

}