package com.javeriana.co.backend.pedidos.domain.model

data class Pedido(
    val id: Long? = null,
    val tipo: String,
    val cantidad: Int,
    val terminada: Boolean
)
