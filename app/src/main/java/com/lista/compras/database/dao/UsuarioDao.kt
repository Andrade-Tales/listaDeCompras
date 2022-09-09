package com.lista.compras.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.lista.compras.model.Usuario

@Dao
interface UsuarioDao {

    @Insert
    suspend fun salva(usuario: Usuario)

    
}