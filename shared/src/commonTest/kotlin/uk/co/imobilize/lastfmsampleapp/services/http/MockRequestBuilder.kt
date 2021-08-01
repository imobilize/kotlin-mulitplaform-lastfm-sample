package uk.co.imobilize.lastfmsampleapp.services.http


class MockRequestBuilder: JSONRequestBuilder {

    var valueToReturn: JsonResponse? = null
    var shouldFail = false
    var urlPassed = ""
    var bodyPassed: Any? = null
    var requestTypeMade = ""

    override fun headers(block: HeadersBuilder.() -> Unit): JSONRequestBuilder {
        return this
    }

    override fun usingURL(url: String): JSONRequestBuilder {
        urlPassed = url
        return this
    }

    override fun with(body: Any): JSONRequestBuilder {
        return this
    }

    override fun post(): JSONRequestBuilder {
        requestTypeMade = "post"
        return this
    }

    override fun get(): JSONRequestBuilder {
        requestTypeMade = "get"
        return this
    }

    override suspend fun excecute(): Result<JsonResponse> {
        if (shouldFail) {
            return Result.failure(RequestError(503, "Some server error"))
        }

        valueToReturn?.let {
            return Result.success(it)
        }

        return Result.success(JsonResponse(200, "unparsable string"))
    }
}

