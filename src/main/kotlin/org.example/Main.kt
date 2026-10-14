package org.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/users") {
            call.respondText("Список пользователей")
        }
        get("/users/{id}") {
            val id = call.parameters["id"]
            call.respondText("Пользователь с id=$id")
        }
        post("/users") {
            call.respondText("Создан пользователь", status = io.ktor.http.HttpStatusCode.Created)
        }
        get("/health") {
            call.respondText("OK")
        }
    }
}