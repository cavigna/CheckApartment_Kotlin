package com.example.checkapartmentkt.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.checkapartmentkt.dao.DepartamentoDao
import com.example.checkapartmentkt.model.Departamento
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Departamento::class], version = 1, exportSchema = false)
abstract class BaseDeDatos : RoomDatabase() {
    abstract fun dao(): DepartamentoDao

    companion object {
        @Volatile
        private var INSTANCE: BaseDeDatos? = null

        fun getBaseDeDatos(context: Context, scope: CoroutineScope): BaseDeDatos {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BaseDeDatos::class.java,
                    "db_deparamentods"
                )
                    .addCallback(DeptoCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }


    private class DeptoCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { baseDeDatos ->
                scope.launch {
                    popularBaseDatos(baseDeDatos.dao())
                }
            }
        }

        suspend fun popularBaseDatos(dao: DepartamentoDao) {

            val listado = listOf(
                Departamento(
                    nombre = "Edificio Link SM",
                    unidad = "505",
                    direccion = "San Martín 970",
                    urlFoto = "https://http2.mlstatic.com/D_NQ_NP_927221-MLC45497689153_042021-O.webp",
                    bath = 0, luces = 0, cocina = 0, dormitorio = 0, terminaciones = 0, puntaje = 0
                ),

                Departamento(
                    nombre = "Barrio Zenteno",
                    unidad = "709",
                    direccion = "Zeneto 1252",
                    urlFoto = "https://http2.mlstatic.com/D_NQ_NP_852648-MLC41532980127_042020-O.webp",
                    bath = 0, luces = 0, cocina = 0, dormitorio = 0, terminaciones = 0, puntaje = 0
                ),
                Departamento(
                    nombre = "Edificio Upper Design",
                    unidad = "312",
                    direccion = "Santa Isabel 330",
                    urlFoto = "https://http2.mlstatic.com/D_NQ_NP_787028-MLC41467659060_042020-O.webp",
                    bath = 0, luces = 0, cocina = 0, dormitorio = 0, terminaciones = 0, puntaje = 0
                ),
                Departamento(
                    nombre = "Edificio Tradición",
                    unidad = "404",
                    direccion ="Eyzaguirre 771",
                    urlFoto = "https://http2.mlstatic.com/D_NQ_NP_940668-MLC45093828481_032021-O.webp",
                    bath = 0, luces = 0, cocina = 0, dormitorio = 0, terminaciones = 0, puntaje = 0
                ),


            )

            for(depto in listado){
                dao.agregarDeaprtamento(depto)
            }





        }
    }
}

