package com.yprodan.recyclerviewhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yprodan.recyclerviewhomework.model.User


class UserItemRecyclerViewAdapter (private val users: List<User>): RecyclerView.Adapter<UserHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        return UserHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item_recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        holder.bind("","","")
    }

    override fun getItemCount() = users.size
}