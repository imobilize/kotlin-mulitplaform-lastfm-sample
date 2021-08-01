package uk.co.imobilize.lastfmsampleapp.services.api

class MockSearchAPIParser: SearchAPIParser {

    var mapToReturn = emptyMap<String, List<Any>>()

    override fun parse(jsonString: String): Map<String, List<Any>> {
        return mapToReturn
    }
}