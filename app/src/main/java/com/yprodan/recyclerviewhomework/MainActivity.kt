package com.yprodan.recyclerviewhomework

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.yprodan.recyclerviewhomework.databinding.ActivityMainBinding

import com.yprodan.recyclerviewhomework.model.UserListViewModel
import com.yprodan.recyclerviewhomework.model.UserListViewModelFactory
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val userList: UserListViewModel by viewModels()

    private val userList = UserListViewModelFactory().create(UserListViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.layoutManager = layoutManager

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



//        binding.btnTest.setOnClickListener {
//            userList.add(
//                "test",
//                "test",
//                "test",
//                "https://www.meme-arsenal.com/memes/3904597739d704ee6d0688119ebeee15.jpg"
//            )
//
//        }

        binding.btnAdd.setOnClickListener {
//            supportFragmentManager.beginTransaction().add(R.id.cnstrntLt,AddContactFromPhoneBookFragment(), "").commit()
            binding.recyclerView.isClickable = false
            binding.recyclerView.isVisible = false
            supportFragmentManager.beginTransaction().add(R.id.cc,AddContactFragment(), "").commit()

        }

        binding.btnTest.setOnClickListener {
            binding.recyclerView.isClickable = false
            binding.recyclerView.isVisible = false

            supportFragmentManager.beginTransaction().add(R.id.cc,AddContactFromPhoneBookFragment(), "").commit()
        }

        userList.getList().observe(this){
            binding.recyclerView.adapter = UserItemRecyclerViewAdapter(it)

//            Log.d("test", it.toString())
            Log.d("test", "obsrv")
        }

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(android.Manifest.permission.READ_CONTACTS), 1)
        }

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED)
        {
            Log.d("test","no")
        }

// Retrieves the profile from the Contacts Provider
        var profileCursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            null
        )



        Log.d("test", "count ${profileCursor!!.count.toString()}")
        Log.d("test", "columns ${profileCursor!!.columnCount}")
    }

    override fun onResume() {
        binding.recyclerView.isClickable = true
        binding.recyclerView.isVisible = true
        super.onResume()
    }
}