import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

fun main() {
    val server = HttpServer.create(InetSocketAddress(8080), 0)
    server.createContext("/health") { ex ->
        val body = "{" + "\"status\":\"ok\"}"
        ex.sendResponseHeaders(200, body.toByteArray().size.toLong())
        ex.responseBody.use { it.write(body.toByteArray()) }
    }
    server.start()
    println("Web API demo started: http://localhost:8080/health")
}
