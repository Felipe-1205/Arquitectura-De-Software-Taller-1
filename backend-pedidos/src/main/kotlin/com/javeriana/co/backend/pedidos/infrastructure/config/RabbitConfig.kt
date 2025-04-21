package com.javeriana.co.backend.pedidos.infrastructure.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.DirectExchange
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.beans.factory.annotation.Value

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

    @Bean fun rabbitTemplate(cf: ConnectionFactory) = RabbitTemplate(cf)

    @Bean fun pedidosQueue() = Queue("pedidosQueue", true)
    @Bean fun pedidosExchange() = DirectExchange("pedidosExchange")
    @Bean fun binding(): Binding =
        BindingBuilder.bind(pedidosQueue()).to(pedidosExchange()).with("pedidos")
}
