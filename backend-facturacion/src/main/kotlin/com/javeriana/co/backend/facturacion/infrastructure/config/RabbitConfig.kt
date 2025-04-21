package com.javeriana.co.backend.facturacion.infrastructure.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig(
    @Value("\${spring.rabbitmq.host}") private val host: String,
    @Value("\${spring.rabbitmq.port}") private val port: Int,
    @Value("\${spring.rabbitmq.username}") private val username: String,
    @Value("\${spring.rabbitmq.password}") private val password: String,
    @Value("\${spring.rabbitmq.virtual-host}") private val virtualHost: String
) {
    @Bean
    fun connectionFactory(): ConnectionFactory {
        val factory = CachingConnectionFactory(host, port)
        factory.username = username
        factory.password = password
        factory.virtualHost = virtualHost
        return factory
    }

    @Bean
    fun rabbitTemplate(cf: ConnectionFactory) = RabbitTemplate(cf)

    /** Cola desde donde el consumer leerá los pedidos */
    @Bean
    fun pedidosQueue() = Queue("pedidosQueue", true)

    /** Exchange directo para pedidos */
    @Bean
    fun pedidosExchange() = DirectExchange("pedidosExchange")

    /** Binding: cola “pedidosQueue” ≤ “pedidosExchange” [routing-key = “pedidos”] */
    @Bean
    fun pedidosBinding(): Binding =
        BindingBuilder
            .bind(pedidosQueue())
            .to(pedidosExchange())
            .with("pedidos")
}
