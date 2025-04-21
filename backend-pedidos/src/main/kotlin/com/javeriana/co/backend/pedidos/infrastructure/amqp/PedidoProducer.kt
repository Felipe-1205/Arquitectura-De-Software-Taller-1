package com.javeriana.co.backend.pedidos.infrastructure.amqp

import com.javeriana.co.backend.pedidos.domain.model.Pedido
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class PedidoProducer(
    private val rabbitTemplate: RabbitTemplate
) {
    fun sendPedido(pedido: Pedido) {
        // Exchange "pedidosExchange", routing-key "pedidos", cola "pedidosQueue"
        rabbitTemplate.convertAndSend("pedidosExchange", "pedidos", pedido)
    }
}
