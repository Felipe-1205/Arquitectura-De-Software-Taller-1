package com.javeriana.co.backend.pedidos.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaPedidoRepository : JpaRepository<PedidoEntity, Long>
