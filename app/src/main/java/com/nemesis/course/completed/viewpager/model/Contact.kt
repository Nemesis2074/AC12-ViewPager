package com.nemesis.course.completed.viewpager.model

import com.google.gson.annotations.SerializedName

class Contact {

    @SerializedName("id")
    var idContact:Int = 0

    @SerializedName("name")
    var name:String = ""

    @SerializedName("work")
    var work:String = ""

    @SerializedName("phone")
    var phone:String = ""

    @SerializedName("email")
    var email:String = ""

    @SerializedName("photo")
    var photo:String = ""

}