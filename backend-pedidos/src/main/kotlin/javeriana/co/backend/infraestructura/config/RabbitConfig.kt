@Configuration
class RabbitConfig {
    @Bean
    fun queue(): Queue = Queue("facturas-queue", true)
}