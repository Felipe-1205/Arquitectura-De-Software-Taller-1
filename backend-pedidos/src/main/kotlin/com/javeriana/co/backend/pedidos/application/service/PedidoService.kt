package com.javeriana.co.backend.pedidos.application.service

import com.javeriana.co.backend.pedidos.application.dto.PedidoDTO
import com.javeriana.co.backend.pedidos.application.port.`in`.CreatePedidoUseCase
import com.javeriana.co.backend.pedidos.domain.model.Pedido
import com.javeriana.co.backend.pedidos.domain.port.out.PedidoRepository
import com.javeriana.co.backend.pedidos.infrastructure.amqp.PedidoProducer
import org.springframework.stereotype.Service

@Service
class PedidoService(
    private val pedidoRepository: PedidoRepository,
    private val pedidoProducer: PedidoProducer
) : CreatePedidoUseCase {

    override fun createPedido(pedidoDTO: PedidoDTO) {
        // 1) Convertir DTO → modelo de dominio
        val pedido = Pedido(
            tipo = pedidoDTO.tipo,
            cantidad = pedidoDTO.cantidad,
            terminada = pedidoDTO.terminada
        )
        // 2) Guardar en H2
        val saved = pedidoRepository.save(pedido)
        // 3) Enviar mensaje a RabbitMQ
        pedidoProducer.sendPedido(saved)
    }
}
