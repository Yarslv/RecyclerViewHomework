package com.yprodan.recyclerviewhomework.model

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

data class UserModel(
    private var _firstName: ObservableField<String> = ObservableField(""),
    private var lastName: ObservableField<String> = ObservableField(""),
    private var career: ObservableField<String> = ObservableField(""),
    private var adress: ObservableField<String> = ObservableField(""),
    private var facebookRef: ObservableField<String> = ObservableField(""),
    private var linkedinRef: ObservableField<String> = ObservableField(""),
    private var wkontakteRef: ObservableField<String> = ObservableField(""),
    private var avatar: ObservableField<String> = ObservableField("")
) : BaseObservable(){


    var firstName : String = ""
        get() = _firstName.toString()
        set(value) {
            field = value
            _firstName.set(value)
            notifyPropertyChanged(0)//no 0
        }
}
