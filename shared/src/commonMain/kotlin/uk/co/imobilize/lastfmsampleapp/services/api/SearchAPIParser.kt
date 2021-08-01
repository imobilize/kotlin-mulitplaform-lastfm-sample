package uk.co.imobilize.lastfmsampleapp.services.api

interface SearchAPIParser {
    fun parse(jsonString: String): Map<String, List<Any>>
}
