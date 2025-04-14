package com.example.application.service

import com.example.domain.model.Pedido
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class PedidoService(private val rabbitTemplate: RabbitTemplate) {
    fun crearPedido(): Pedido {
        val pedido = Pedido(1, "Café con leche")
        println("Pedido creado: $pedido")
        rabbitTemplate.convertAndSend("cafeteria.exchange", "pedido.creado", pedido.descripcion)
        return pedido
    }
}
