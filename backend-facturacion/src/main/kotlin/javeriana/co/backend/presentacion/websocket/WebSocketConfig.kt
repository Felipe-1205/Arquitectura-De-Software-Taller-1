package javeriana.co.backend.presentacion.websocket

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

import javeriana.co.backend.presentacion.websocket.MyWebSocketHandler

@Configuration
@EnableWebSocket
class WebSocketConfig(private val myHandler: MyWebSocketHandler) : WebSocketConfigurer {
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(myHandler, "/ws/chat").setAllowedOrigins("*")
    }
}