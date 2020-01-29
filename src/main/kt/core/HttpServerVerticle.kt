package core

import io.vertx.core.AbstractVerticle
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Route
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext

class HttpServerVerticle : BaseVerticle() {

    override fun start() {
        val router: Router = Router.router(vertx)

        composeAPI(router, "/", HttpMethod.GET).handler(::greeting)

        vertx.createHttpServer()!!.requestHandler(router).listen(9999)
    }

    private fun composeAPI(router: Router?, api: String, method: HttpMethod): Route {
        return router!!.route().path(api).method(method)
    }

    private fun greeting(context: RoutingContext): Unit {
        var resp = context.response()
        resp.putHeader("Content-type", "text/plain; charset=utf-8")
        resp.end("Hello from vertx with kotlin:")
    }



}