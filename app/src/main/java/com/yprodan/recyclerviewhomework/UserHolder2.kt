package com.yprodan.recyclerviewhomework

import android.graphics.Bitmap
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yprodan.recyclerviewhomework.databinding.ContactItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.databinding.UserItemRecyclerViewBinding

class UserHolder2(private val binding: ContactItemRecyclerViewBinding, itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(
        firstName: String = "",
        lastName: String = "",
        career: String = "",
        avatar: Bitmap?
    ) {
        binding.firstNameTextView.text = firstName
        binding.lastNameTextView.text = lastName
        binding.careerTextView.text = career
        binding.avatarImageView.setImageBitmap(avatar)
    }
}