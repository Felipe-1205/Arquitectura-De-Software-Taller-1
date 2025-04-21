package com.javeriana.co.backend.facturacion.domain.port.out

import com.javeriana.co.backend.facturacion.domain.model.Factura

interface FacturaRepository {
  fun save(factura: Factura): Factura
}
