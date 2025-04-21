package javeriana.co.backend.presentacion.websocket

import org.springframework.stereotype.Service
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.util.concurrent.CopyOnWriteArraySet

@Service
class WebSocketMessagingService {

    private val sessions = CopyOnWriteArraySet<WebSocketSession>()

    fun registerSession(session: WebSocketSession) {
        sessions += session
    }

    fun removeSession(session: WebSocketSession) {
        sessions -= session
    }

    fun sendToAll(message: String) {
        sessions.forEach { session ->
            if (session.isOpen) {
                session.sendMessage(TextMessage(message))
            }
        }
    }
}