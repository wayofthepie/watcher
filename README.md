# Spring/Kotlin/GraphQL
Quick example of Spring, Kotlin and GraphQL. 

# Sample Mutations And Queries
Run `./gradlew bootRun`, and navigate to http://localhost:8080/graphiql. Now create a Human!

Request:
```
mutation {
  writeHuman(name:"test") {
    id
  }
}
```

Response:
```
{
  "data": {
    "writeHuman": {
      "id": "some-uuid"
    }
  }
}
```

Now find your human!

Request:
```
query {
  human(id:"some-uuid") {
    id
    name
  }
}
```

Response:
```
{
  "data": {
    "human": {
      "id": "some-uuid",
      "name": "test"
    }
  }
}
```

# Note
Until https://github.com/graphql-java/graphql-spring-boot/pulls is merged, you
will have to locally build the graphql-spring-boot-starter from the version in 
that pull request.
