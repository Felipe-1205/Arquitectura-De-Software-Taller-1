package com.javeriana.co.backend.facturacion.infrastructure.persistence

import com.javeriana.co.backend.facturacion.domain.model.Factura
import com.javeriana.co.backend.facturacion.domain.port.out.FacturaRepository
import org.springframework.stereotype.Component

@Component
class FacturaRepositoryAdapter(
  private val jpa: JpaFacturaRepository
) : FacturaRepository {

  override fun save(factura: Factura): Factura {
    val entity = FacturaEntity(
      pedidoId = factura.pedidoId,
      costo = factura.costo
    )
    val saved = jpa.save(entity)
    return Factura(
      id = saved.id,
      pedidoId = saved.pedidoId,
      costo = saved.costo
    )
  }
}
