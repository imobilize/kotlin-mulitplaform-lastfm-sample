package uk.co.imobilize.lastfmsampleapp.services.api

import kotlinx.serialization.json.Json
import uk.co.imobilize.lastfmsampleapp.services.http.AnyValueDeSerializer

class SearchAPIParserImpl: SearchAPIParser {

    override fun parse(jsonString: String): Map<String, List<Any>> {

        val jsonObject: Any? = Json.decodeFromString(AnyValueDeSerializer(), jsonString)

        val map = jsonObject as? Map<String, Any>

        val results = map?.get("results") as? Map<String, Any>

        val artistMatches = results?.get("artistmatches") as? Map<String, Any>

        val artistList = artistMatches?.get("artist") as? List<Map<String, Any>> ?: emptyList()

        return mapOf("artists" to artistList)
    }
}