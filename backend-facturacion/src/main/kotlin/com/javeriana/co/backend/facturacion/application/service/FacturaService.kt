package com.javeriana.co.backend.facturacion.application.service

import com.javeriana.co.backend.facturacion.application.dto.PedidoMessageDTO
import com.javeriana.co.backend.facturacion.application.port.`in`.CreateFacturaUseCase
import com.javeriana.co.backend.facturacion.domain.model.Factura
import com.javeriana.co.backend.facturacion.domain.port.out.FacturaRepository
import com.javeriana.co.backend.facturacion.infrastructure.websocket.WebSocketService
import org.springframework.stereotype.Service

@Service
class FacturaService(
    private val facturaRepository: FacturaRepository,
    private val wsService: WebSocketService
) : CreateFacturaUseCase {

  override fun generarFactura(pedido: PedidoMessageDTO) {
    // 1) Simular "cool‑down" de 15 s
    Thread.sleep(15_000)

    // 2) Calcular costo “quemado”
    val costo = pedido.cantidad * 10.0

    // 3) Crear y guardar factura
    val factura = Factura(
      pedidoId = pedido.id,
      costo = costo
    )
    val saved = facturaRepository.save(factura)

    // 4) Emitir la factura por WebSocket al frontend
    wsService.enviarFactura(saved)
  }
}
