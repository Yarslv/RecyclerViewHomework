package com.yprodan.recyclerviewhomework.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.squareup.picasso.Picasso
import com.yprodan.recyclerviewhomework.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.ArrayList

class UserListViewModel : ViewModel() {
    private var picassoLoader = Picasso.get()
    private var userList: MutableLiveData<ArrayList<User>> = MutableLiveData(ArrayList())

    suspend fun addUser(
        firstName: String = "",
        lastName: String = "",
        career: String,
        imgPath: String
    ) = withContext(Dispatchers.IO) {
        userList.value?.add(
            User(
                firstName, lastName, career,
                avatar = picassoLoader.load(imgPath).error(R.drawable.ic_baseline_info_24).get()
            )
        )
        Log.d("user", "added")
    }

    fun add(firstName: String = "", lastName: String = "", career: String, imgPath: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                userList.value?.add(
                    User(
                        firstName, lastName, career,
                        avatar = picassoLoader.load(imgPath).error(R.drawable.ic_baseline_info_24)
                            .get()
                    )
                )
                userList.postValue(userList.value)
            }
        }
        Log.d("test", "add")
    }

    fun getList(): LiveData<ArrayList<User>> = userList
}