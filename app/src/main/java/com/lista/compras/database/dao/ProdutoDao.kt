package com.lista.compras.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.lista.compras.model.Produto

@Dao
interface ProdutoDao {

    // Query busca
    @Query("SELECT * FROM Produto")
    fun buscaTodos(): List<Produto>

    // Query salvar
    @Insert
    fun salva(produto: Produto)
}