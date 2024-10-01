package com.example.dbroom

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "contacts")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name :String,
    val number : String,
    val date: Date,
    val isACTIVE : Int
)
