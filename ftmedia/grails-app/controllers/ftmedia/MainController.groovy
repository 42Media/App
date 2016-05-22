package ftmedia

import ftCore.security.User
import ftLibrary.VideoAsset
import ftLibrary.MusicAsset

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
