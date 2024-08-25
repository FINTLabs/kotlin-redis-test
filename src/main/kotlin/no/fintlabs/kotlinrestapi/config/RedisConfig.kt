package no.fintlabs.kotlinrestapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory
import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import org.springframework.data.redis.serializer.StringRedisSerializer

@Configuration
class RedisConfig {

    @Bean
    fun reactiveRedisTemplate(factory: ReactiveRedisConnectionFactory): ReactiveRedisTemplate<String, Any> {
        val studentSerializer = Jackson2JsonRedisSerializer(Any::class.java)

        val serializationContext = RedisSerializationContext
            .newSerializationContext<String, Any>(StringRedisSerializer())
            .value(studentSerializer)
            .build()

        return ReactiveRedisTemplate(factory, serializationContext)
    }

}