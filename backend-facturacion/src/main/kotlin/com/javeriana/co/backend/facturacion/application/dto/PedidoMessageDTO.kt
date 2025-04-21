package com.javeriana.co.backend.facturacion.application.dto

data class PedidoMessageDTO(
    val id: Long,
    val tipo: String,
    val cantidad: Int,
    val terminada: Boolean
)
