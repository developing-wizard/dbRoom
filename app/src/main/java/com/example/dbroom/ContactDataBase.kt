package com.example.dbroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Contact::class] , version = 1)
@TypeConverters(Converters::class)
abstract class ContactDataBase : RoomDatabase() {
 abstract  fun contactDao() : ContactDAO

 companion object {

  val migrate1_2 = object : Migration(1,2)
  {
   override fun migrate(db: SupportSQLiteDatabase) {
    db.execSQL("ALTER TABLE contacts ADD COLUMN isACTIVE INTEGER NOT NULL DEFAULT(1)")
   }

  }

 @Volatile
  private var INSTANCE : ContactDataBase? = null
  fun getDatabase(context: Context) : ContactDataBase
  {
   if (INSTANCE == null) {
    synchronized(this) {
     INSTANCE =
      Room.databaseBuilder(context.applicationContext, ContactDataBase::class.java, "contactDB")
       .build()
    }
   }
   return INSTANCE!!
  }
 }
}