package core

import io.vertx.core.AbstractVerticle

open class BaseVerticle : AbstractVerticle() {

    open fun name(): String? {
        return this::class.simpleName
    }

    override fun start() {
        super.start()
    }

    override fun stop() {
        super.stop()
    }
}