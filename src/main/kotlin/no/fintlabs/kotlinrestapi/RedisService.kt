package no.fintlabs.kotlinrestapi

import org.springframework.data.redis.core.ReactiveRedisTemplate
import org.springframework.data.redis.core.getAndAwait
import org.springframework.data.redis.core.multiGetAndAwait
import org.springframework.data.redis.core.setAndAwait
import org.springframework.stereotype.Service

@Service
class RedisService(
    private val reactiveRedisTemplate: ReactiveRedisTemplate<String, Any>
) {

    suspend fun save(key: String, value: Any): Boolean? {
        return reactiveRedisTemplate.opsForValue().setAndAwait(key, value)
    }

    suspend fun get(key: String): Any? {
        return reactiveRedisTemplate.opsForValue().getAndAwait(key)
    }

    suspend fun getAll(): Collection<Any?> {
        return reactiveRedisTemplate.opsForValue().multiGetAndAwait()
    }

}