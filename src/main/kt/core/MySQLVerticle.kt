package core

import io.vertx.core.AbstractVerticle
import io.vertx.core.logging.LoggerFactory
import io.vertx.kotlin.core.json.json
import io.vertx.kotlin.core.json.obj
import io.vertx.redis.client.Redis
import io.vertx.redis.client.RedisAPI
import io.vertx.redis.client.RedisOptions

class MySQLVerticle : BaseVerticle() {
    val logger = LoggerFactory.getLogger(this::class.simpleName)

    override fun start() {
        var config = json {
            obj("host" to "")
        }
    }
}