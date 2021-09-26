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



    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {

        GlobalScope.launch {
            userList.addUser(
                "test6",
                "test",
                "test",
                "https://www.meme-arsenal.com/memes/1db48102eb4085bc911c2fedbf58c578.jpg"
            )
            userList.addUser(
                "test3",
                "test",
                "test",
                "https://www.meme-arsenal.com/memes/1db48102eb4085bc911c2fedbf58c578.jpg"
            )
        }

        userList.getList().observe(this){
            binding.recyclerView.adapter = UserItemRecyclerViewAdapter(it)
        }

        return super.onCreateView(name, context, attrs)
    }
}