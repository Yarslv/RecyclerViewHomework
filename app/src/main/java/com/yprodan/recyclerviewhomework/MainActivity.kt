package com.yprodan.recyclerviewhomework

import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.yprodan.recyclerviewhomework.databinding.ActivityMainBinding
import com.yprodan.recyclerviewhomework.model.User

import com.yprodan.recyclerviewhomework.model.UserListViewModel
import com.yprodan.recyclerviewhomework.model.UserListViewModelFactory
import kotlinx.coroutines.*
import java.security.acl.Permission
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val userList: UserListViewModel by viewModels()

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

        // Sets the columns to retrieve for the user profile
        var projection = arrayOf(
            ContactsContract.Profile._ID,
            ContactsContract.Profile.DISPLAY_NAME_PRIMARY,
            ContactsContract.Profile.LOOKUP_KEY,
            ContactsContract.Profile.PHOTO_THUMBNAIL_URI
        )

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
        getContacts()
    }

    private fun getContacts() {
        // this method is use to read contact from users device.
        // on below line we are creating a string variables for
        // our contact id and display name.
        var contactId = ""
        var displayName = ""
        // on below line we are calling our content resolver for getting contacts
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        // on blow line we are checking the count for our cursor.
        if (cursor!!.count > 0) {
            Log.d("test",">")
            Log.d("test","${cursor.count}")
            // if the count is greater than 0 then we are running a loop to move our cursor to next.
            while (cursor.moveToNext()) {
                Log.d("test","${cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))}")


                // on below line we are getting the phone number.
                val hasPhoneNumber =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                        .toInt()
                if (hasPhoneNumber > 0) {
                    // we are checking if the has phone number is > 0
                    // on below line we are getting our contact id and user name for that contact
                    contactId =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                    displayName =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    // on below line we are calling a content resolver and making a query
                    val phoneCursor = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(contactId),
                        null
                    )
                    // on below line we are moving our cursor to next position.
                    if (phoneCursor!!.moveToNext()) {
                        // on below line we are getting the phone number for our users and then adding the name along with phone number in array list.
                        val phoneNumber =
                            phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))


                        Log.d("test", "$displayName $phoneNumber")
                    }
                    // on below line we are closing our phone cursor.
                    phoneCursor.close()
                }
            }
        }
        // on below line we are closing our cursor.
        cursor.close()
        // on below line we are hiding our progress bar and notifying our adapter class.
      }
}