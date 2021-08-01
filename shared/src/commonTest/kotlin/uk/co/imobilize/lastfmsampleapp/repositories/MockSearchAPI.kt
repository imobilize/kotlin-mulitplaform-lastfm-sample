package uk.co.imobilize.lastfmsampleapp.repositories

import uk.co.imobilize.lastfmsampleapp.services.api.SearchAPI

class MockSearchAPI: SearchAPI {

    var artistsToReturn = emptyMap<String, Any>()
    var albumsToReturn = emptyMap<String, Any>()
    var tracksToReturn = emptyMap<String, Any>()

    override suspend fun searchArtist(artistName: String): Map<String, Any> {
        return artistsToReturn
    }

    override suspend fun searchAlbum(albumName: String): Map<String, Any> {
        return albumsToReturn
    }

    override suspend fun searchTrack(trackName: String): Map<String, Any> {
        return tracksToReturn
    }

}
