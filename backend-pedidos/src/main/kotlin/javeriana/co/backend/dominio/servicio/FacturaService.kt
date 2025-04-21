package javeriana.co.backend.dominio.servicio

import org.springframework.stereotype.Service

@Service
class FacturaService(private val PeticionRepository: PeticionRepository, private val facturaProducer: FacturaProducer){
    fun procesarPeticion(peticionDTO: PeticionDTO): Factura {
        val peticion = peticionRepository.save(
            Peticion(
                tipo = peticionDTO.tipo,
                cantidad = peticionDTO.cantidad,
                terminada = peticionDTO.terminada
            )
        )

        // Lógica de creación de factura
        val factura = Factura(
            peticionId = peticion.id,
            costo = peticion.cantidad * 10.0
        )

        // Enviar por RabbitMQ
        facturaProducer.enviarFactura(factura)

        return factura
    }
}