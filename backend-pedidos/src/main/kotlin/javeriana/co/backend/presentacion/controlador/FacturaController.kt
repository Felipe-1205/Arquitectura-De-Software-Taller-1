package javeriana.co.backend.presentacion.controlador

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/facturas")
class FacturaController(private val facturaService: FacturaService){

    @PostMapping
    fun crearFactura(@RequestBody peticionDTO: PeticionDTO): ResponseEntity<Any> {
        return try {
            val factura = facturaService.procesarPeticion(peticionDTO)
            ResponseEntity.status(201).body("Factura enviada correctamente: $factura")
        } catch (e: Exception) {
            ResponseEntity.status(500).body("Error al procesar la petición: ${e.message}")
        }
    } 
}