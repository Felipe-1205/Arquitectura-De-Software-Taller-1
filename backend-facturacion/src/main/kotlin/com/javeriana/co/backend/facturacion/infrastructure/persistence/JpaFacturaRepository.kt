package com.javeriana.co.backend.facturacion.infrastructure.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JpaFacturaRepository : JpaRepository<FacturaEntity, Long>
