package com.lista.compras.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

// Implementação do Parcelable com o plugin parcelize
@Parcelize
data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal,
    val imagem: String? = null
) : Parcelable