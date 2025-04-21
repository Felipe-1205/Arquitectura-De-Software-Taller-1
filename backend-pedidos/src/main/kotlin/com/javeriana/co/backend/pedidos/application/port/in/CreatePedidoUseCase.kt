package com.javeriana.co.backend.pedidos.application.port.`in`

import com.javeriana.co.backend.pedidos.application.dto.PedidoDTO

interface CreatePedidoUseCase {
    fun createPedido(pedidoDTO: PedidoDTO)
}
