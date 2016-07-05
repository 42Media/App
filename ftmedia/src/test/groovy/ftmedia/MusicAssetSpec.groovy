package ftlibrary

import ftcore.security.User
import grails.test.mixin.*
import spock.lang.*
import ftlibrary.MusicAsset

@TestFor(MusicAssetController)
@Mock(MusicAsset)
class MusicAssetControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params.title            = 'Test Music'
        params.trackArtist      = 'Test Music'
        params.release          = 2016
        params.inserted         = new Date()
        params.user             = new User(username: 'admin', password: 'password')
    }

    void "test saving an invalid MusicAsset"() {
        when:
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'

            def musicAsset = new MusicAsset()
                musicAsset.validate()

            controller.save(musicAsset)

        then:
            model.musicAsset!= null
            view == 'create'
    }

    void "test saving a valid musicAsset"() {
        when:
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            response.reset()

            populateValidParams(params)
            def musicAsset = new MusicAsset(params)

            controller.save(musicAsset)

        then:
            response.redirectedUrl == '/'
            controller.flash.message != null
            MusicAsset.count() == 1
    }
}