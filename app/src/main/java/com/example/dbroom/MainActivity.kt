package com.example.dbroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var dataBase: ContactDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBase = ContactDataBase.getDatabase(this)

        GlobalScope.launch {
            dataBase.contactDao().insertContact(Contact(1, "Talha", "03095100669", Date(), 1))
            dataBase.contactDao().deleteContact(1)
            dataBase.contactDao().updateContact(Contact(1, "Talha", "03095100669", Date(), 1))

        }

        fun getcontact(view: View) {
            dataBase.contactDao().getContact().observe(this, Observer {
                Log.d("values", it.toString())
            })
        }
    }

}