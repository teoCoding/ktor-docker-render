package com.teocoding

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/") {

            val envVariable = System.getenv("MY_ENV_VARIABLE")

            val secretFile = File("etc/secrets/my_secret")

            val response = """
                My env variable: $envVariable
                
                My secret content: ${secretFile.readText()}
            """.trimIndent()

            call.respondText(response)
        }
    }
}
