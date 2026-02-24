package m15_webapidemo

import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress
import java.nio.charset.StandardCharsets

fun main() {
    val server = HttpServer.create(InetSocketAddress(8080), 0)

    // health check: 最常见的运维探针接口。
    server.createContext("/health") { ex ->
        val body = "{\"status\":\"ok\"}"
        val bytes = body.toByteArray(StandardCharsets.UTF_8)

        ex.responseHeaders.add("Content-Type", "application/json; charset=utf-8")
        ex.sendResponseHeaders(200, bytes.size.toLong())
        ex.responseBody.use { it.write(bytes) }
    }

    // fallback: 其他路径返回 404
    server.createContext("/") { ex ->
        val body = "{\"error\":\"not found\"}"
        val bytes = body.toByteArray(StandardCharsets.UTF_8)
        ex.responseHeaders.add("Content-Type", "application/json; charset=utf-8")
        ex.sendResponseHeaders(404, bytes.size.toLong())
        ex.responseBody.use { it.write(bytes) }
    }

    server.start()
    println("Web API demo started: http://localhost:8080/health")
}
