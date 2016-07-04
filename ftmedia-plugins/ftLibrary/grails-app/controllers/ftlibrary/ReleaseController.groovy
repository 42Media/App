package ftlibrary

class ReleaseController {

    def index() { }

    def list()
    {
        MusicService service = new MusicService()
        ArrayList res = service.listReleases()
        [releases: res]
    }

    def show(String mbid)
    {
        MusicService service = new MusicService()
        Map res = service.getRelease(mbid)
        [release: res]
    }
}
