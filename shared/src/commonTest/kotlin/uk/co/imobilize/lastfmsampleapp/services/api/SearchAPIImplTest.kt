package uk.co.imobilize.lastfmsampleapp.services.api

import uk.co.imobilize.lastfmsampleapp.utils.runTest
import uk.co.imobilize.lastfmsampleapp.services.http.JsonResponse
import uk.co.imobilize.lastfmsampleapp.services.http.MockRequestBuilder
import uk.co.imobilize.lastfmsampleapp.utils.ConsoleLogger
import uk.co.imobilize.lastfmsampleapp.utils.MockConsoleLogger
import kotlin.native.concurrent.ThreadLocal
import kotlin.test.*


class SearchAPIImplTest {

    lateinit var mockLogger: ConsoleLogger
    lateinit var mockParser: MockSearchAPIParser
    lateinit var mockRequestBuilder: MockRequestBuilder

    lateinit var searchAPI: SearchAPI

    @BeforeTest
    fun setUp() {

        mockLogger = MockConsoleLogger()
        mockParser = MockSearchAPIParser()
        mockRequestBuilder = MockRequestBuilder()

        searchAPI = SearchAPIImpl(mockRequestBuilder, mockParser, mockLogger, "SOME_KEY")
    }


    @AfterTest
    fun tearDown() {
    }

    @Test
    fun searchArtistCallsAPIWithValidURL()  = runTest {

        val expectedURL = "https://ws.audioscrobbler.com/2.0/?method=artist.search&artist=Ed Sheeran&api_key=SOME_KEY&format=json"

        mockRequestBuilder.valueToReturn = JsonResponse(200)

        searchAPI.searchArtist("Ed Sheeran")

        assertEquals(expectedURL, mockRequestBuilder.urlPassed)
    }

    @Test
    fun searchAlbumCallsAPIWithValidURL()  = runTest {

        val expectedURL = "https://ws.audioscrobbler.com/2.0/?method=album.search&album=believe&api_key=SOME_KEY&format=json"

        mockRequestBuilder.valueToReturn = JsonResponse(200)

        searchAPI.searchAlbum("believe")

        assertEquals(mockRequestBuilder.urlPassed, expectedURL)
    }

    @Test
    fun searchTrackCallsAPIWithValidURL()  = runTest {

        val expectedURL = "https://ws.audioscrobbler.com/2.0/?method=track.search&track=Believe&api_key=SOME_KEY&format=json"

        mockRequestBuilder.valueToReturn = JsonResponse(200)

        searchAPI.searchTrack("Believe")

        assertEquals(mockRequestBuilder.urlPassed, expectedURL)
    }

    @Test
    fun searchArtistValidResponseContainsArtists()  = runTest {

        val artistList = listOf(mapOf("name" to "Cher"), mapOf("name" to "Ed Sheeran"))
        val responseMap = mapOf("artists" to artistList)

        mockRequestBuilder.valueToReturn = JsonResponse(200)

        mockParser.mapToReturn = responseMap

        val response = searchAPI.searchArtist("Ed Sheeran")

        val artists = response["artists"] as? List<Map<String, Any>>

        assertEquals(artists?.count(), 2)
    }

    @Test
    fun searchAlbum() {

    }

    @Test
    fun searchTrack() {

    }
}