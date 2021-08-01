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
            					"listeners": "1291411",
            					"mbid": "bfcc6d75-a6a5-4bc6-8282-47aec8531818",
            					"url": "https://www.last.fm/music/Cher",
            					"streamable": "0",
            					"image": [{
            						"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "small"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "medium"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "large"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "extralarge"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "mega"
            					}]
            				},
            				{
            					"name": "Cheryl Cole",
            					"listeners": "631273",
            					"mbid": "2d499150-1c42-4ffb-a90c-1cc635519d33",
            					"url": "https://www.last.fm/music/Cheryl+Cole",
            					"streamable": "0",
            					"image": [{
            						"#text": "https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "small"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/64s/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "medium"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "large"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "extralarge"
            					}, {
            						"#text": "https://lastfm.freetls.fastly.net/i/u/300x300/2a96cbd8b46e442fc41c2b86b821562f.png",
            						"size": "mega"
            					}]
            				}
            			]
            		}
            	}
            }
        """.trimIndent()

        val responseMap = parser.parse(jsonString)
        val artists = responseMap["artists"] as? List<Map<String, Any>>

        assertEquals(2, artists?.size)

        artists?.first()?.apply {

            assertEquals("Cher", get("name"))
            assertEquals("https://lastfm.freetls.fastly.net/i/u/34s/2a96cbd8b46e442fc41c2b86b821562f.png", get("thumbnailUrl"))
            assertEquals( "https://lastfm.freetls.fastly.net/i/u/174s/2a96cbd8b46e442fc41c2b86b821562f.png", get("imageUrl"))
            assertEquals("https://www.last.fm/music/Cher" , get("url"))
            assertEquals("bfcc6d75-a6a5-4bc6-8282-47aec8531818", get("mbid"))
            assertEquals("1291411", get("listeners"))

        }


    }
}