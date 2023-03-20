package com.example.sbtechincaltest

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CompanyOffer::class],
    version = 2,
    exportSchema = false)
abstract class OffersDb : RoomDatabase() {
    abstract val dao: OffersDao

    companion object {
        @Volatile
        private var INSTANCE: OffersDao? = null

        fun getDaoInstance(context: Context): OffersDao {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = buildDatabase(context).dao
                    INSTANCE = instance
                }
                return instance
            }
        }

        private fun buildDatabase(context: Context): OffersDb = Room.databaseBuilder(
            context.applicationContext,
            OffersDb::class.java,
            "offers_database")
            .fallbackToDestructiveMigration()
            .build()
    }
}