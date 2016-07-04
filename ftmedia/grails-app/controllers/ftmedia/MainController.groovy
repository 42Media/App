package ftmedia

import ftcore.security.User
import ftlibrary.VideoAsset
import ftlibrary.MusicAsset

class MainController {


    def springSecurityService

    def index()
    {
        def user        = springSecurityService.currentUser

        def allVideos   = VideoAsset.findAllByUser(user, [max: 10])
        def allMusic    = MusicAsset.findAllByUser(user, [max: 10])

        render (view: 'index', model: [
                user: user,
                videoList: allVideos,
                musicList: allMusic
        ])
    }
}
