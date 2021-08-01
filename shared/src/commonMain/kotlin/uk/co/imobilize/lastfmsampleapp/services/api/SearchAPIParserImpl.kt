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

        val artists = artistList.map {

            val updatedMap = it.toMutableMap()
            val imageArray = updatedMap["image"] as? List<Map<String, String>>

            val smallImageMap = imageArray?.firstOrNull { it["size"] == "small" }
            val largeImageMap = imageArray?.firstOrNull { it["size"] == "large" }

            updatedMap["thumbnailUrl"] = smallImageMap?.get("#text") ?: ""
            updatedMap["imageUrl"] = largeImageMap?.get("#text") ?: ""
            updatedMap
        }
        return mapOf("artists" to artists)
    }
}