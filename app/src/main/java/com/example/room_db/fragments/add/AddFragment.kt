package com.example.room_db.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room_db.R
import com.example.room_db.model.User
import com.example.room_db.viewmodel.UserViewModel


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var btn_Add: Button
    private lateinit var addFirstName_et: EditText
    private lateinit var addLastName_et: EditText
    private lateinit var addAge_et: EditText


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        btn_Add = view.findViewById(R.id.add_btn)
        addAge_et = view.findViewById(R.id.addAge_et)
        addFirstName_et = view.findViewById(R.id.addFirstName_et)
        addLastName_et = view.findViewById(R.id.addLastName_et)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        btn_Add.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {

        val firstName = addFirstName_et.text.toString()
        val lastName = addLastName_et.text.toString()
        val age = addAge_et.text

        if (inputCheck(firstName, lastName, age)){
            // Create User Object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            // Add Data to DataBase
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{

            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()

        }
    }
    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}