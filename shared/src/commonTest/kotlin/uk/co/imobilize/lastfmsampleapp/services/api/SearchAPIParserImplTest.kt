package uk.co.imobilize.lastfmsampleapp.services.api

import uk.co.imobilize.lastfmsampleapp.utils.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class SearchAPIParserImplTest {

    lateinit var parser: SearchAPIParserImpl

    @BeforeTest
    fun setUp() {

        parser = SearchAPIParserImpl()
    }

    @Test
    fun searchAPIParserForArtists()  = runTest {

        val jsonString = """
            {
            	"results": {
            		"artistmatches": {
            			"artist": [{
            					"name": "Cher",
                                "image_small": "http://userserve-ak.last.fm/serve/50/342437.jpg",
                                "image": "http://userserve-ak.last.fm/serve/160/342437.jpg",
                                "mbid": "bfcc6d75-a6a5-4bc6-8282-47aec8531818",
            					"url": "www.last.fm/artist/cher"
            				},
            				{
            					"name": "Ed Sheeran",
                                "image_small": "http://userserve-ak.last.fm/serve/50/342438.jpg",
                                "image": "http://userserve-ak.last.fm/serve/160/342438.jpg",
                                "mbid": "bfcc6d75-a6a5-4bc6-8282-47aec8531819",
            					"url": "www.last.fm/artist/ed-sheran"
            				}
            			]
            		}
            	}
            }
        """.trimIndent()

        val responseMap = parser.parse(jsonString)
        val artists = responseMap["artists"] as? List<Map<String, Any>>

        assertEquals(2, artists?.size)
        assertEquals("Cher", artists?.first()?.get("name"))
    }
}