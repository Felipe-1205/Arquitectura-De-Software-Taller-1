package javeriana.co.backend.dominio.modelo

import jakarta.persistence.*

@Entity
data class Factura(
    val peticionId: Long,
    val costo: Double
)