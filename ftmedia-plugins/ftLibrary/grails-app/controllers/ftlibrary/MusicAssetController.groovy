package ftlibrary

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MusicAssetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def lastFMService


    //Own Functions

    def showLast()
    {
        def musicAssetList = MusicAsset.listOrderByInserted(max: 5, order: "desc")

        render (view: 'index', model: [
                musicAssetList: musicAssetList
        ])
    }

    def sort()
    {
        def tag     = params.tag
        def order   = params.order

        def musicAssetList = [:]

        if(tag == "inserted")
        {
            musicAssetList = MusicAsset.listOrderByInserted(order: order)
        }

        if(tag == "title")
        {
            musicAssetList = MusicAsset.listOrderByTitle(order: order)
        }

        render (view: 'index', model: [
                musicAssetList: musicAssetList
        ])
    }

    def filter()
    {

        def musicAssetList = [:]

        def album   = params.filterMusicAlbum
        def saenger = params.filterMusicSaenger
        def year    = params.int('filterMusicYear')

        if(!album && !saenger && !year)
        {
            musicAssetList = MusicAsset.findAll()
        }
        else
        {
            musicAssetList = MusicAsset.findAllByTitleOrTrackArtistOrYear(album, saenger, year)
        }


        render (view: 'index', model: [
                musicAssetList: musicAssetList
        ])
    }

    //Scaffold Functions

    def index(Integer max) {
        params.max = Math.min(max ?: 50, 100)
        respond MusicAsset.list(params), model:[musicAssetCount: MusicAsset.count()]
    }

    def show(MusicAsset musicAsset) {

        def trackMap = [:], artistMap = [:]

        trackMap = lastFMService.getMetaByTrack(musicAsset.trackArtist ,musicAsset.title)
        artistMap = lastFMService.getMetaByArtist(musicAsset.trackArtist )

        artistMap.remove("Name")

        respond musicAsset, model:[mapData:trackMap ,mapDataArtist:artistMap]
    }

    def create() {

        def musicAsset = new MusicAsset(params)
            musicAsset.inserted = new Date()

        respond musicAsset
    }

    @Transactional
    def save(MusicAsset musicAsset) {
        if (musicAsset == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (musicAsset.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond musicAsset.errors, view:'create'
            return
        }

        musicAsset.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'musicAsset.label', default: 'MusicAsset'), musicAsset.id])
                redirect (uri: "/")
            }
            '*' { respond musicAsset, [status: CREATED] }
        }
    }

    def edit(MusicAsset musicAsset)
    {
        respond musicAsset
    }

    @Transactional
    def update(MusicAsset musicAsset) {
        if (musicAsset == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (musicAsset.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond musicAsset.errors, view:'edit'
            return
        }

        musicAsset.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'musicAsset.label', default: 'MusicAsset'), musicAsset.id])
                redirect (uri: "/")
            }
            '*'{ respond musicAsset, [status: OK] }
        }
    }

    @Transactional
    def delete(MusicAsset musicAsset) {

        if (musicAsset == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        musicAsset.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'musicAsset.label', default: 'MusicAsset'), musicAsset.id])
                redirect (uri: "/")
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'musicAsset.label', default: 'MusicAsset'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
