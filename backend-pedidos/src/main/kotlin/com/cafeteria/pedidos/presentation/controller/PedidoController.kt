package com.example.presentation.controller

import com.example.application.service.PedidoService
import org.springframework.stereotype.Component

@Component
class PedidoController(private val pedidoService: PedidoService) {
    fun run() {
        val pedido = pedidoService.crearPedido()
        println("Enviado a facturación: ${'$'}{pedido.descripcion}")
    }
}
