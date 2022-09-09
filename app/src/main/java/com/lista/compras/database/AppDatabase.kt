package com.lista.compras.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lista.compras.database.converter.Converters
import com.lista.compras.database.dao.ProdutoDao
import com.lista.compras.database.dao.UsuarioDao
import com.lista.compras.model.Produto
import com.lista.compras.model.Usuario

@Database(
    entities = [
        Produto::class,
        Usuario::class
    ],
    version = 2,
    exportSchema = true
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun produtoDao(): ProdutoDao

    abstract fun usuarioDao(): UsuarioDao

    companion object {
        @Volatile
        private var db: AppDatabase? = null
        fun instancia(context: Context): AppDatabase {
            return db ?: Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "compras.db"
            ).addMigrations(MIGRATION_1_2)
                .build().also {
                    db = it
                }
        }
    }
}