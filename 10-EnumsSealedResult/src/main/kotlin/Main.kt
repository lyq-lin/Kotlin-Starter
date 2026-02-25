package m10_enumssealedresult

// 本模块主题：枚举 + sealed 结果建模

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

fun render(result: ApiResult): String = when (result) {
    is ApiResult.Success -> "OK: ${result.data}"
    is ApiResult.Failure -> "ERR: ${result.reason}"
}

fun main() {
    println(endpoint(Env.DEV))
    println(render(ApiResult.Success("ok")))
    println(render(ApiResult.Failure("timeout")))
}
