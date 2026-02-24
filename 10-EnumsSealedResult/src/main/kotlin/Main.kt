enum class Env { DEV, STAGING, PROD }

sealed class ApiResult {
    data class Success(val data: String) : ApiResult()
    data class Failure(val reason: String) : ApiResult()
}

fun endpoint(env: Env): String = when (env) {
    Env.DEV -> "http://localhost:8080"
    Env.STAGING -> "https://staging.example.com"
    Env.PROD -> "https://example.com"
}

fun main() {
    println(endpoint(Env.DEV))
    val result: ApiResult = ApiResult.Success("ok")
    println(result)
}
