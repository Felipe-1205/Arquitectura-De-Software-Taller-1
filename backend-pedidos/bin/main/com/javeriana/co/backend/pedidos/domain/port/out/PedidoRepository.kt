package com.javeriana.co.backend.pedidos.domain.port.out

import com.javeriana.co.backend.pedidos.domain.model.Pedido

interface PedidoRepository {
    fun save(pedido: Pedido): Pedido
}
