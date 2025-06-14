package ru.nvgsoft.testeffectivemobile.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [
    OfferDbModel::class,
    VacancyDbModel::class],
    version = 1, exportSchema = false)
@TypeConverters(ConverterList::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object{
        private var INSTANCE:AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "job.db"

        fun getInstance(application: Application): AppDatabase{
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK){
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}