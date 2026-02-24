package basics

enum class Environment {
    DEV, TEST, PROD
}

sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Failure(val message: String) : ApiResult<Nothing>()
}

fun endpointFor(env: Environment): String = when (env) {
    Environment.DEV -> "https://dev.api.local"
    Environment.TEST -> "https://test.api.local"
    Environment.PROD -> "https://api.service.com"
}

fun parsePort(raw: String): ApiResult<Int> = try {
    val port = raw.toInt()
    if (port in 1..65535) ApiResult.Success(port) else ApiResult.Failure("port out of range")
} catch (_: NumberFormatException) {
    ApiResult.Failure("invalid number")
}

fun demoEnumsSealedAndResult() {
    val endpoint = endpointFor(Environment.DEV)
    val portResult = parsePort("8080")
    println("[enum/sealed/result] endpoint=$endpoint, portResult=$portResult")
}
