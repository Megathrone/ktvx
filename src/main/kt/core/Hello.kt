import io.vertx.core.AbstractVerticle
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServer


class Hello : AbstractVerticle() {

    override fun start() {
        val server = vertx.createHttpServer()
        server.requestHandler{req -> req.response().end("nmsl")}.listen(9999)
    }

    override fun stop() {

    }
}

fun main() {
    val verticle = Hello()
    Vertx.vertx().deployVerticle(verticle)
}

