package com.yprodan.recyclerviewhomework

import android.content.DialogInterface
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yprodan.recyclerviewhomework.databinding.FragmentAddContactFromPhoneBinding
import com.yprodan.recyclerviewhomework.model.User
import com.yprodan.recyclerviewhomework.model.UserListViewModel
import com.yprodan.recyclerviewhomework.model.UserListViewModelFactory

class AddContactFromPhoneBookFragment : DialogFragment() {
    private lateinit var binding: FragmentAddContactFromPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAddContactFromPhoneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val layoutManager = LinearLayoutManager(context)
        binding.rcclrVw.layoutManager = layoutManager

        var contacts = getContacts()

        binding.rcclrVw.adapter = UserItemRecyclerViewAdapter2(contacts)
        
        binding.imgWvBackArrow.setOnClickListener {

            with(UserListViewModelFactory()
                .create(UserListViewModel::class.java)
            ){
                for(i in contacts){
                    add(i.getFirstName(), imgPath = "https://24smi.org/public/media/400x248/person/2017/12/28/ck1mq9zla1xl-shrek.jpg")
                }

            }
//            UserListViewModelFactory()
//                .create(UserListViewModel::class.java)
//                .add(firstName = "testt", imgPath = "https://24smi.org/public/media/400x248/person/2017/12/28/ck1mq9zla1xl-shrek.jpg")
            dismiss()
        }
        Toast.makeText(context, "ddd",Toast.LENGTH_SHORT).show()

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDismiss(dialog: DialogInterface) {
        Toast.makeText(context, "ClosePhoneBook",Toast.LENGTH_SHORT).show()
        super.onDismiss(dialog)
    }

    override fun onDestroy() {
        Toast.makeText(context, "ClosePhoneBook",Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }


    private fun getContacts(): ArrayList<User> {
        val result = arrayListOf<User>()
        var contactId = ""
        var displayName = ""
        val cursor = activity?.contentResolver?.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )
        if (cursor!!.count > 0) {
            Log.d("test",">")
            Log.d("test","${cursor.count}")
            while (cursor.moveToNext()) {
                result.add(User(firstName = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)),
                ))


                Log.d("test",
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                )
       val hasPhoneNumber =
                    cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))
                        .toInt()
                if (hasPhoneNumber > 0) {
                    contactId =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID))
                    displayName =
                        cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))

                    val phoneCursor = activity?.contentResolver?.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(contactId),
                        null
                    )

                    if (phoneCursor!!.moveToNext()) {

                        val phoneNumber =
                            phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))


                        Log.d("test", "$displayName $phoneNumber")
                    }

                    phoneCursor.close()
                }
            }
        }
        cursor.close()
        return result
    }

}