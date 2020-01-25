package core

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpServer

class HttpServerVerticle : AbstractVerticle() {


    override fun start() {
        val server:HttpServer = vertx.createHttpServer();
        server.requestHandler { httpServerRequest ->
            var resp = httpServerRequest.response()
            resp.putHeader("Content-type", "text/plain; charset=utf-8")
            resp.end("Hello from vertx with kotlin")
        }
        server.listen(9999)
    }
}