package uk.co.imobilize.lastfmsampleapp.services.http

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class KtorHttpServiceImpl(private val client: HttpClient): HttpService {

    override fun jsonRequestBuilder(): JSONRequestBuilder {

//        val builder = KtorJSONRequestBuilder(client)
        val builder = FakeRequestBuilder()

        builder.headers {
//            it.apply {
//                append("Content-Type", "application/json")
//                append("Accept-Language", "en-GB")
//            }
        }

        return builder
    }
}

class KtorJSONRequestBuilder(private val client: HttpClient): JSONRequestBuilder {

    private var method = HttpMethod.Get
    private var requestURL  = ""
    private var headerStrings = emptyList<Pair<String, String>>().toMutableList()
    private var requestBody: Any? = null

    override fun headers(block: (HeadersBuilder) -> Unit): JSONRequestBuilder {

        val headersBuilder = object : HeadersBuilder {
            override fun append(key: String, value: String): HeadersBuilder {
                headerStrings.add(Pair(key, value))
                return this
            }
        }

        headersBuilder.apply(block)

        return this
    }

    override fun usingURL(url: String): JSONRequestBuilder {
        requestURL = url
        return this
    }

    override fun with(body: Any): JSONRequestBuilder {
        requestBody = body
        return this
    }

    override fun post(): JSONRequestBuilder {
        method = HttpMethod.Post
        return this
    }

    override fun get(): JSONRequestBuilder {
        method = HttpMethod.Get
        return this
    }

    override suspend fun excecute(): Result<JsonResponse> {

        try {
            val response: HttpResponse = when (method) {
                HttpMethod.Post -> {
                    postRequest()
                }
                else -> {
                    getRequest()
                }
            }

            val stringBody = response.receive<String>()
            val jsonResponse = JsonResponse(response.status.value, stringBody)

            return Result.success(jsonResponse)

        } catch (cause: Throwable) {

            return Result.failure(cause)
        }
    }

    private suspend fun getRequest() = client.get<HttpResponse>(requestURL) {

        addHeaders()
    }


    private suspend fun postRequest() = client.post<HttpResponse>(requestURL) {
        if (requestBody != null) {
            body = requestBody as Any
        }
        addHeaders()
    }

    private fun HttpRequestBuilder.addHeaders() {
        headers {
            headerStrings.forEach {
                append(it.first, it.second)
            }
        }
    }
}
