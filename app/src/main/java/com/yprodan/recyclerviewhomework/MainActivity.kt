package com.yprodan.recyclerviewhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yprodan.recyclerviewhomework.databinding.ActivityMainBinding
import com.yprodan.recyclerviewhomework.model.User

import com.yprodan.recyclerviewhomework.model.UserListViewModel
import com.yprodan.recyclerviewhomework.model.UserListViewModelFactory
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userList: UserListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager



//        GlobalScope.launch {
            userList.add(
                "test6",
                "test",
                "test",
                "https://www.meme-arsenal.com/memes/3904597739d704ee6d0688119ebeee15.jpg"
            )

            userList.add(
                "test3",
                "test",
                "test",
                "https://www.meme-arsenal.com/memes/3904597739d704ee6d0688119ebeee15.jpg"
            )

//        }

        binding.btnTest.setOnClickListener {
            userList.add(
                "test",
                "test",
                "test",
                "https://www.meme-arsenal.com/memes/3904597739d704ee6d0688119ebeee15.jpg"
            )
        }

        userList.getList().observe(this){
            binding.recyclerView.adapter = UserItemRecyclerViewAdapter(it)

//            Log.d("test", it.toString())
            Log.d("test", "obsrv")
        }

        userList.add(
            "test3",
            "test",
            "test",
            "https://www.meme-arsenal.com/memes/3904597739d704ee6d0688119ebeee15.jpg"
        )
    }
}