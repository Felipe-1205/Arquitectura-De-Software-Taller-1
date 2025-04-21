package com.javeriana.co.backend.facturacion.infrastructure.amqp

import com.javeriana.co.backend.facturacion.application.dto.PedidoMessageDTO
import com.javeriana.co.backend.facturacion.application.port.`in`.CreateFacturaUseCase
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class FacturaConsumer(
  private val createFactura: CreateFacturaUseCase
) {

  @RabbitListener(queues = ["pedidosQueue"])
  fun onPedidoReceived(pedido: PedidoMessageDTO) {
    createFactura.generarFactura(pedido)
  }
}
