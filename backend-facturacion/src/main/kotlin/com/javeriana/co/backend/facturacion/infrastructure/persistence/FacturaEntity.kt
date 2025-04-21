package com.javeriana.co.backend.facturacion.infrastructure.persistence

import jakarta.persistence.*

@Entity
@Table(name = "facturas")
data class FacturaEntity(
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  val id: Long = 0,
  val pedidoId: Long,
  val costo: Double
)
