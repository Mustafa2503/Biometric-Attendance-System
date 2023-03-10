package com.group.attendancesystem.room.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.group.attendancesystem.room.dao.EmployeeDao
import com.group.attendancesystem.room.entity.Employee
import com.group.attendancesystem.room.entity.EmployeeAttendance

@Database(entities = [Employee::class, EmployeeAttendance::class], version = 3, exportSchema = false)
abstract class EmployeeDatabase: RoomDatabase() {

    abstract fun getEmployeeDao():EmployeeDao

    companion object{
        private const val TAG = "EMPLOYEE_DATABASE"
        private const val DATABASE_NAME = "EmployeeDatabase"

        @Volatile
        private var INSTANCE: EmployeeDatabase? = null

        fun getInstance(context: Context): EmployeeDatabase?{
            if (INSTANCE==null){
                    Log.d(TAG, " >>> Creating new database instance")
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext,
                            EmployeeDatabase::class.java,
                            DATABASE_NAME).addMigrations().fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()

            }
            Log.d(TAG, " >>> Getting the database instance")
            return INSTANCE
        }

        fun destroyInstance() {
            Log.d(TAG, " >>> Destroying app database instance")
            INSTANCE = null
        }
    }

}