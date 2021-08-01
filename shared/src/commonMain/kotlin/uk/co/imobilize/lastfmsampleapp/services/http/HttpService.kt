package uk.co.imobilize.lastfmsampleapp.services.http

interface HttpService {
    fun jsonRequestBuilder(): JSONRequestBuilder
}


interface JSONRequestBuilder {
    fun headers(block: HeadersBuilder.() -> Unit): JSONRequestBuilder

    fun usingURL(url: String): JSONRequestBuilder
    fun with(body: Any): JSONRequestBuilder
    fun post(): JSONRequestBuilder
    fun get(): JSONRequestBuilder

    suspend fun excecute(): Result<JsonResponse>
}

interface HeadersBuilder {
    fun append(key: String, value: String): HeadersBuilder
}

class RequestError(val errorCode: Int, message: String): Throwable(message) {}

data class JsonResponse(val status: Int, val jsonString: String = "")
