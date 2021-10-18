package com.yprodan.recyclerviewhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.yprodan.recyclerviewhomework.databinding.FragmentAddContactBinding
import com.yprodan.recyclerviewhomework.databinding.UserItemRecyclerViewBinding
import com.yprodan.recyclerviewhomework.model.UserListViewModel
import com.yprodan.recyclerviewhomework.model.UserListViewModelFactory

class AddContactFragment : DialogFragment() {

    private lateinit var binding: FragmentAddContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddContactBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
//        super.onResume()
//        dialog?.onWindowAttributesChanged(dialog?.window?.attributes.apply {
//            this?.width = WindowManager.LayoutParams.MATCH_PARENT
//            this?.height = WindowManager.LayoutParams.MATCH_PARENT
//        })
        super.onResume()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            UserListViewModelFactory().create(UserListViewModel::class.java).add(firstName = "testt", imgPath = "https://24smi.org/public/media/400x248/person/2017/12/28/ck1mq9zla1xl-shrek.jpg")
            dismiss()
        }

        binding.imgWvBackArrow.setOnClickListener {
            dismiss()
        }
    }

}