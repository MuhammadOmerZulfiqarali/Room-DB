package com.example.room_db.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.room_db.model.User

//** Contains the methods used for accessing the database **//

@Dao    //** Annotating the interface with Dao **//
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)  //** It will ignore the new user with same name **//
    fun addUser(user: User)     //suspend keyword is used for coroutines

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()




    @Query("Select * from user_Table ORDER By id ASC") //Ascending order annotating with the query that will fetch the data
    fun readAllData(): LiveData<List<User>>


}
