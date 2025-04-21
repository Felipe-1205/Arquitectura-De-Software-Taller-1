package com.javeriana.co.backend.facturacion.application.port.`in`

import com.javeriana.co.backend.facturacion.application.dto.PedidoMessageDTO

interface CreateFacturaUseCase {
  fun generarFactura(pedido: PedidoMessageDTO)
}
