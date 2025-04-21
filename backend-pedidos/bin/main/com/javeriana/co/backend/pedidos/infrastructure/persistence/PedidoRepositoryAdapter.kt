package com.javeriana.co.backend.pedidos.infrastructure.persistence

import com.javeriana.co.backend.pedidos.domain.model.Pedido
import com.javeriana.co.backend.pedidos.domain.port.out.PedidoRepository
import org.springframework.stereotype.Component

@Component
class PedidoRepositoryAdapter(
    private val jpaRepository: JpaPedidoRepository
) : PedidoRepository {

    override fun save(pedido: Pedido): Pedido {
        val entity = PedidoEntity(
            tipo = pedido.tipo,
            cantidad = pedido.cantidad,
            terminada = pedido.terminada
        )
        val saved = jpaRepository.save(entity)
        return Pedido(
            id = saved.id,
            tipo = saved.tipo,
            cantidad = saved.cantidad,
            terminada = saved.terminada
        )
    }
}
