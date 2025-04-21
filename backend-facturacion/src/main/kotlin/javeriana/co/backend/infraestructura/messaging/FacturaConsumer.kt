package javeriana.co.backend.infraestructura.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

import javeriana.co.backend.dominio.modelo.Factura
import javeriana.co.backend.dominio.servicio.WebSocketMessagingService

@Service
class FacturaConsumer(
    private val mapper: ObjectMapper,
    private val messagingService: WebSocketMessagingService
) {

    @RabbitListener(queues = ["facturas-queue"])
    fun recibirFactura(factura: Factura) {
        println("✅ Factura recibida: $factura")

        // Espera 30 segundos
        Thread.sleep(30_000)

        val json = mapper.writeValueAsString(factura)

        // Acá podés guardar en base de datos, enviar a otro sistema, etc.
        messagingService.sendToAll(json)
    }
}