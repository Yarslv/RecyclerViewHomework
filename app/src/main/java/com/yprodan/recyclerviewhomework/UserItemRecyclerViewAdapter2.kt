package com.yprodan.recyclerviewhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.yprodan.recyclerviewhomework.databinding.ContactItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.databinding.UserItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.model.User


class UserItemRecyclerViewAdapter2 (private val users: List<User>): RecyclerView.Adapter<UserHolder2>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder2 {
        ContactItemRecyclerViewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.contact_item_recycler_view, parent, false)).apply {
            this.trashImageView.setOnClickListener {
                Toast.makeText(parent.context, this.firstNameTextView.text, Toast.LENGTH_LONG).show()
                this.trashImageView.setImageDrawable(ResourcesCompat.getDrawable(parent.context.resources, R.drawable.added_icon, null))

            }
            return UserHolder2(this, this.root)
        }

    }

    override fun onBindViewHolder(holder: UserHolder2, position: Int) {

        users[holder.adapterPosition].apply {
            holder.bind(getFirstName(),getLastName(),getCareer(), getAvatar())
        }

    }

    override fun getItemCount() = users.size
}