package br.com.zup.simcityacademy.data.datasource.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.zup.simcityacademy.data.datasource.local.dao.BimesterDAO
import br.com.zup.simcityacademy.domain.model.Bimester

@Database(entities = [Bimester::class], version = 4)
abstract class BimesterDataBase : RoomDatabase() {

    abstract fun bimesterDAO() : BimesterDAO

    companion object{
        private var INTANCE : BimesterDataBase? = null

        fun getDataBase(context: Context): BimesterDataBase{
            val tempInstance = INTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BimesterDataBase::class.java,
                    "bimester_dataBase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INTANCE = instance
                return instance
            }
        }
    }
}