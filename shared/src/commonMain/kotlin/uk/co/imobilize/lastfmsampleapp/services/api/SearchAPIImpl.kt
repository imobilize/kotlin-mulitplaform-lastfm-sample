package uk.co.imobilize.lastfmsampleapp.services.api

import uk.co.imobilize.lastfmsampleapp.services.http.JSONRequestBuilder
import uk.co.imobilize.lastfmsampleapp.utils.ConsoleLogger

class SearchAPIImpl(
    private val requestBuilder: JSONRequestBuilder,
    private val parser: SearchAPIParser,
    private val logger: ConsoleLogger,
    private val apiKey: String = "",
    private val baseUrl: String = "https://ws.audioscrobbler.com/2.0"
) : SearchAPI {

    override suspend fun searchArtist(artistName: String): Map<String, Any> {
        val builder = requestBuilder
            .get()
            .usingURL("$baseUrl/?method=artist.search&artist=${artistName}&api_key=${apiKey}&format=json")

        val result = builder.excecute()
        val response = result.getOrNull()

        logger.info("Received search artist response: $response")

        val responseMap = if(response?.jsonString != null) {
                parser.parse(response.jsonString)
            } else {
                emptyMap()
            }

        return responseMap
    }

    override suspend fun searchAlbum(albumName: String): Map<String, Any> {
        TODO("Not yet implemented")
    }

    override suspend fun searchTrack(trackName: String): Map<String, Any> {
        TODO("Not yet implemented")
    }
}