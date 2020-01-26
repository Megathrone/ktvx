package core

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

class HttpServerVerticle : AbstractVerticle() {

    override fun start() {
        val server = vertx.createHttpServer();
        val router = Router.router(vertx)

        router.route().path("/:name").method(HttpMethod.GET).handler(::make)
        server.requestHandler(router).listen(9999)
    }

    private fun make(context: RoutingContext): Unit {
        var resp = context.response()
        var name = context.request().getParam("name")
        resp.putHeader("Content-type", "text/plain; charset=utf-8")
        resp.end("Hello from vertx with kotlin: $name")
    }
}