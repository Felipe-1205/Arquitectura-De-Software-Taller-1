package com.javeriana.co.backend.facturacion.domain.model

data class Factura(
    val id: Long? = null,
    val pedidoId: Long,
    val costo: Double
)
