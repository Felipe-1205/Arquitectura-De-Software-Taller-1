package javeriana.co.backend.dominio.modelo

import jakarta.persistence.*
import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
data class Factura(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val cliente: String?,
    val total: Double?
)