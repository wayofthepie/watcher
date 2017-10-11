package cd.river

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan


@SpringBootApplication
@ComponentScan("cd.river")
class WatcherApplication

fun main(args: Array<String>) {
    SpringApplication.run(WatcherApplication::class.java, *args)
}

