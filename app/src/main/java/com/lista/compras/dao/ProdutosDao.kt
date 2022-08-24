package com.lista.compras.dao

import com.lista.compras.model.Produto


// Data Access Object = DAO
// Uso do Companion Object para salvar em uma lista mutável não atrelada a função

class ProdutosDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}