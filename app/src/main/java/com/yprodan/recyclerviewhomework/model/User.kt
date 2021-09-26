package com.yprodan.recyclerviewhomework.model

import android.graphics.Bitmap

class User(
    private var firstName: String = "",
    private var lastName: String = "",
    private var career: String = "",
    private var address: String = "",
    private var facebookRef: String = "",
    private var linkedinRef: String = "",
    private var wkontakteRef: String = "",
    private var avatar: Bitmap? = null,
){
    fun getFirstName() = firstName
    fun getLastName() = lastName
    fun getCareer() = career
    fun getAvatar() = avatar
}