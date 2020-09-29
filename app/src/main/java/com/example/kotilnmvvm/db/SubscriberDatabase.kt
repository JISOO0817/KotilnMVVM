package com.example.kotilnmvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotilnmvvm.Subscriber

@Database(entities = [Subscriber::class],version = 1)
abstract class SubscriberDatabase : RoomDatabase()
{

    abstract val subscriberDAO : SubscriberDAO

    //코틀린 싱글톤
    companion object{
        @Volatile
        private var INSTANCE : SubscriberDatabase? = null
            fun getInstance(context: Context):SubscriberDatabase{
                synchronized(this){
                    var instance : SubscriberDatabase? = INSTANCE
                        if(instance == null){
                            instance = Room.databaseBuilder(
                                context.applicationContext,
                                SubscriberDatabase::class.java,
                                "subscriber_data_database"
                            ).build()
                        }

                    return instance
                }
            }
    }

}

