package com.lista.compras.model

import java.math.BigDecimal

class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    val imagem: String?  = null
)