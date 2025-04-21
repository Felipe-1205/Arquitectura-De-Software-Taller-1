package com.javeriana.co.backend.facturacion.infrastructure.websocket

import com.javeriana.co.backend.facturacion.domain.model.Factura
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

@Service
class WebSocketService(
  private val template: SimpMessagingTemplate
) {
  fun enviarFactura(factura: Factura) {
    template.convertAndSend("/topic/factura", factura)
  }
}
