package com.javeriana.co.backend.pedidos.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "pedidos")
data class PedidoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val tipo: String,
    val cantidad: Int,
    val terminada: Boolean
)
