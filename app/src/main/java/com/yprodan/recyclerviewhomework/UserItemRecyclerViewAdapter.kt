package com.yprodan.recyclerviewhomework

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yprodan.recyclerviewhomework.databinding.UserItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.model.User

class UserItemRecyclerViewAdapter (private val users: List<User>): RecyclerView.Adapter<UserHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        UserItemRecyclerViewBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.user_item_recycler_view, parent, false)).apply {
            this.trashImageView.setOnClickListener {
                (users as ArrayList).removeAt(this.position!!.value)
                notifyItemRemoved(this.position!!.value)
                for(i in this.position!!.value..users.size){
                        notifyItemChanged(i)
                }

//                Toast.makeText(parent.context, "${this.hack?.a} || ${users[this.hack.a].getPosition()}", Toast.LENGTH_SHORT).show()
            }

            return UserHolder(this, this.root)
        }
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        users[holder.adapterPosition].apply {
            holder.bind(getFirstName(),getLastName(),getCareer(), getAvatar())
//            setPosition(holder.adapterPosition)
        }
    }

    override fun getItemCount() = users.size
}