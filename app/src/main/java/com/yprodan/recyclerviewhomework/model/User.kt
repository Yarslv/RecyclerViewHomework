package com.yprodan.recyclerviewhomework.model

class User (
    private var firstName: String = "",
    private var lastName: String = "",
    private var career: String = "",
    private var address: String = "",
    private var facebookRef: String = "",
    private var linkedinRef: String = "",
    private var wkontakteRef: String = "",
    private var avatar: String = "",
){
    fun getFirstName() = firstName
    fun getLastName() = lastName
    fun getCareer() = career
}