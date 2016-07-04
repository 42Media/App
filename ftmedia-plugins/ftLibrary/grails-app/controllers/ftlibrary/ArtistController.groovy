package ftlibrary

import ftexternalmedia.LastFMService

class ArtistController {

    def index(Integer max)
    {
        params.max = Math.min(max ?: 10, 100)
        respond MusicAsset.list(params), model:[musicAssetCount: MusicAsset.count()]
    }

    def list()
    {
        MusicService service = new MusicService()
        def res = service.listArtists(true)
        [albumArtists: res]
    }

    def show(String artist)
    {
        MusicService service = new MusicService()
        LastFMService lastFM = new LastFMService()
        ArrayList releaseData = service.listReleases([artist: artist])
        Map artistData = lastFM.getMetaByArtist(artist)
        [releases: releaseData, artist:artistData]
    }

}
