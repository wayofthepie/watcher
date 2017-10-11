package cd.river.config

import cd.river.graphql.Mutation
import cd.river.graphql.Query
import com.coxautodev.graphql.tools.SchemaParser
import graphql.schema.GraphQLSchema
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphQlConfig {
    @Bean
    fun schema(query: Query, mutation: Mutation): GraphQLSchema = SchemaParser
            .newParser()
            .file("humans.graphqls")
            .resolvers(query, mutation)
            .build()
            .makeExecutableSchema()
}