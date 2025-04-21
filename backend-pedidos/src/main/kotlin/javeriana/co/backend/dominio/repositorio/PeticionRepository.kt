package javeriana.co.backend.dominio.repositorio

import com.tuapp.entity.Peticion
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PeticionRepository : JpaRepository<Peticion, Long>