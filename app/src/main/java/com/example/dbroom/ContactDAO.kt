package com.example.dbroom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {
    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    @Query("SELECT * FROM CONTACTS WHERE id = :iD")
    suspend fun deleteContact(iD : Int)

    @Update
       suspend fun updateContact(contact: Contact)

    @Query("SELECT * FROM CONTACTS")
     fun getContact() : LiveData<List<Contact>>
}