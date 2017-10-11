package cd.river.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer


@Configuration
class RedisConfig {
    @Bean
    fun jedisConnectionFactory(): JedisConnectionFactory {
        val config = RedisStandaloneConfiguration()
        config.hostName = "localhost"
        config.port = 6379
        return JedisConnectionFactory(config)
    }

    @Bean
    fun redis(): RedisTemplate<String, Any> {
        val template = RedisTemplate<String, Any>()
        template.connectionFactory = jedisConnectionFactory()
        template.keySerializer = StringRedisSerializer()
        template.hashValueSerializer = GenericToStringSerializer(Any::class.java)
        template.valueSerializer = GenericToStringSerializer(Any::class.java)
        return template
    }
}