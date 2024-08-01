package com.example.room_db.repository

import androidx.lifecycle.LiveData
import com.example.room_db.data.UserDao
import com.example.room_db.model.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

     fun addUser(user: User){
        userDao.addUser(user)
    }

    fun updateUser(user: User){
        userDao.updateUser(user)
    }

    fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    fun deleteAllUser(){
        userDao.deleteAllUsers()
    }

}