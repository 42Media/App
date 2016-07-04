package ftmedia

import ftcore.security.User
import ftlibrary.MusicService
import ftlibrary.VideoAsset
import ftlibrary.MusicAsset

class MainController {


    def springSecurityService

    def index()
    {
        def user        = springSecurityService.currentUser
        MusicService service = new MusicService()

        def allVideos   = VideoAsset.findAll([max: 10])
        def allMusic    = MusicAsset.findAll([max: 10])
        def newMusic    = service.listReleases([max: 10])

        render (view: 'index', model: [
                user: user,
                videoList: allVideos,
                musicList: newMusic
        ])
    }
}
