package cd.river.graphql

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

@Component
class QueryImpl(private val redis: RedisTemplate<String, String>) : Query {
    override fun human(id: String): Human? =
            redis.opsForValue().get(id)?.let { name ->
                Human(id, name)
            }
}