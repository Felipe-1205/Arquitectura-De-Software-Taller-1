package javeriana.co.backend.infraestructura.messaging

import com.tuapp.model.Factura
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class FacturaConsumer {

    @RabbitListener(queues = ["facturas-queue"])
    fun recibirFactura(factura: Factura) {
        println("✅ Factura recibida: $factura")

        // Acá podés guardar en base de datos, enviar a otro sistema, etc.
    }
}