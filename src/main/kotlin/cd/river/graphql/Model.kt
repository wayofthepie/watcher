package cd.river.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver

interface Query: GraphQLQueryResolver {
    fun human(id: String): Human?
}

interface Mutation : GraphQLMutationResolver {
    fun writeHuman(name: String): Human
}

data class Human(val id: String, val name: String)