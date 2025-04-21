package com.javeriana.co.backend.pedidos.presentation.controller

import com.javeriana.co.backend.pedidos.application.dto.PedidoDTO
import com.javeriana.co.backend.pedidos.application.port.`in`.CreatePedidoUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/pedidos")
class PedidoController(
    private val createPedidoUseCase: CreatePedidoUseCase
) {

    @PostMapping
    fun createPedido(@RequestBody pedidoDTO: PedidoDTO): ResponseEntity<Void> {
        createPedidoUseCase.createPedido(pedidoDTO)
        return ResponseEntity.ok().build()
    }
}
