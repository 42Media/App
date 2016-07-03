package ftlibrary

class ReleaseController {

    def index() { }

    def list()
    {
        ArrayList res = MusicService.listReleases()
        [releases: res]
    }

    def show(String mbid)
    {
        Map res = MusicService.getRelease(mbid)
        [release: res]
    }
}
