package com.javeriana.co.backend.pedidos.application.dto

data class PedidoDTO(
    val tipo: String,
    val cantidad: Int,
    val terminada: Boolean
)
