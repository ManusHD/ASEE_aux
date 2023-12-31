package es.unex.gps.weathevent.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import es.unex.gps.weathevent.model.Ciudad
import es.unex.gps.weathevent.model.User
import es.unex.gps.weathevent.model.UserCiudadCrossRef
import es.unex.gps.weathevent.model.Event

@Database(version = 5, entities = [User::class, Ciudad::class, Event::class, UserCiudadCrossRef::class], exportSchema = false)
abstract class WeathEventDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun eventDao() : EventDao
    abstract fun ciudadDao() : CiudadDao

    companion object {
        private var INSTANCE: WeathEventDataBase? = null

        fun getInstance(context: Context): WeathEventDataBase {
            if (INSTANCE == null) {
                synchronized(WeathEventDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        WeathEventDataBase::class.java,
                        "WeathEventDataBase.db" // Nombre de la base de datos
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
