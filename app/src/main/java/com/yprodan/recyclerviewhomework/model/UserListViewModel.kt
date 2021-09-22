package com.yprodan.recyclerviewhomework.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class UserListViewModel: ViewModel() {

    private var userList: MutableLiveData<ArrayList<User>> = MutableLiveData(ArrayList())

    fun addUser(user: User){
        userList.value?.add(user)
    }

    fun getList(): LiveData<ArrayList<User>> = userList
}