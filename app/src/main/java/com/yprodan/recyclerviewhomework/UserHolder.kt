package com.yprodan.recyclerviewhomework

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yprodan.recyclerviewhomework.databinding.UserItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.model.Hack

class UserHolder(private val binding: UserItemRecyclerViewBinding, itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(
        firstName: String = "",
        lastName: String = "",
        career: String = "",
        avatar: Bitmap?
    ) {
        Log.d("bind", adapterPosition.toString())
        binding.firstNameTextView.text = firstName
        binding.lastNameTextView.text = lastName
        binding.careerTextView.text = career
        binding.avatarImageView.setImageBitmap(avatar)
        binding.position = Hack(adapterPosition)
    }
}