package cd.river.graphql

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component
import java.util.*

@Component
class MutationImpl(private val redis: RedisTemplate<String, Any>) : Mutation {
    override fun writeHuman(name: String): Human =
            UUID.randomUUID().toString().let { id ->
                redis.opsForValue().set(id, name)
                Human(id, name)
            }

}