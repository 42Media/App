package ftmedia

import ftcore.security.User
import ftlibrary.VideoAsset
import ftlibrary.MusicAsset

class MainController {


    def springSecurityService

    def index()
    {
        def user        = springSecurityService.currentUser

        def allVideos   = VideoAsset.findAll()
        def allMusic    = MusicAsset.findAll()

        render (view: 'index', model: [
                user: user,
                videoList: allVideos,
                musicList: allMusic
        ])
    }
}
