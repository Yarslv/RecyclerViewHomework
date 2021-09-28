package com.yprodan.recyclerviewhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.yprodan.recyclerviewhomework.databinding.UserItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.model.User


class UserItemRecyclerViewAdapter (private val users: List<User>): RecyclerView.Adapter<UserHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        UserItemRecyclerViewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.user_item_recycler_view, parent, false)).apply {
            this.root.setOnClickListener {
                Toast.makeText(parent.context, this.firstNameTextView.text, Toast.LENGTH_LONG).show()
            }
            return UserHolder(this, this.root)
        }

    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        users[holder.adapterPosition].apply {
            holder.bind(getFirstName(),getLastName(),getCareer(), getAvatar())
        }

    }

    override fun getItemCount() = users.size
}