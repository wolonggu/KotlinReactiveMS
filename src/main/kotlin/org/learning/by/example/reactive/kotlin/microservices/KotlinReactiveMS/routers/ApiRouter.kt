package org.learning.by.example.reactive.kotlin.microservices.KotlinReactiveMS.routers

import org.learning.by.example.reactive.kotlin.microservices.KotlinReactiveMS.handlers.ApiHandler
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router


class ApiRouter(val handler : ApiHandler) {

    companion object {
        val API_PATH = "/api"
        val HELLO_PATH = "/hello"
    }

    fun doRoute() = router {
        (accept(MediaType.APPLICATION_JSON_UTF8) and API_PATH).nest {
            GET(HELLO_PATH, handler::getHello)
        }
    }
}
