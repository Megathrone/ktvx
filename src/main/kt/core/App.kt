package core


import io.vertx.core.Vertx
import io.vertx.core.logging.LoggerFactory

fun main() {
    val vertx: Vertx? = Vertx.vertx()
    val logger = LoggerFactory.getLogger("[Entry point]")
    logger.info("[Main Server]: Starting verticles...")

    val vs: List<BaseVerticle> = listOf<BaseVerticle>(HttpServerVerticle(), MySQLVerticle())

    vs.forEach { v ->
        vertx!!.deployVerticle(v) {
            if (it.succeeded()) {
                logger.info("[Main Server]: Startting ${v.name()} done.")
            } else {
                logger.error(it.cause())
            }
        }
    }
}