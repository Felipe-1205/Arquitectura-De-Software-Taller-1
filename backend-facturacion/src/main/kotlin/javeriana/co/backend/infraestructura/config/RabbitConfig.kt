package javeriana.co.backend.infraestructura.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    @Bean
    fun queue(): Queue = Queue("facturas-queue", true)

    @Bean
    fun messageConverter(): MessageConverter = Jackson2JsonMessageConverter()
}