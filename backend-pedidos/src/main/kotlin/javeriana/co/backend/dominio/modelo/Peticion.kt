package javeriana.co.backend.dominio.modelo

import jakarta.persistence.*

@Entity
data class Peticion(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val tipo: String,
    val cantidad: Integer,
    val terminada: Boolean
)