package javeriana.co.backend.presentacion.websocket

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.handler.TextWebSocketHandler

import javeriana.co.backend.dominio.servicio.WebSocketMessagingService

@Component
class MyWebSocketHandler(
    private val messagingService: WebSocketMessagingService
) : TextWebSocketHandler() {

    override fun afterConnectionEstablished(session: WebSocketSession) {
        messagingService.registerSession(session)
        println("🟢 Conectado: ${session.id}")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        messagingService.removeSession(session)
        println("🔴 Desconectado: ${session.id}")
    }
}