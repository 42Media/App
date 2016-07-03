package ftlibrary

class ArtistController {

    def index(Integer max)
    {
        params.max = Math.min(max ?: 10, 100)
        respond MusicAsset.list(params), model:[musicAssetCount: MusicAsset.count()]
    }

    def list()
    {
        def res = MusicService.listArtists(true)
        [albumArtists: res]
    }

    def show(String artist)
    {
        ArrayList res = MusicService.listReleases(artist)
        [releases: res]
    }

}
