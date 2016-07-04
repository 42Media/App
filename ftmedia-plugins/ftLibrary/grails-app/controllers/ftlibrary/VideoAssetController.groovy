package ftlibrary

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VideoAssetController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    //Own Functions

    def showLast()
    {
        def user        = springSecurityService.currentUser

        def videoAssetList = VideoAsset.findAllByUser(user, [sort: 'inserted', max: 5, order: "desc"])

        render (view: 'index', model: [
                videoAssetList: videoAssetList
        ])
    }

    def sort()
    {
        def user    = springSecurityService.currentUser

        def tag     = params.tag
        def order   = params.order

        def videoAssetList = [:]

        if(tag == "inserted")
        {
            videoAssetList = VideoAsset.findAllByUser(user, [sort: 'inserted', order: order])
        }

        if(tag == "title")
        {
            videoAssetList = VideoAsset.findAllByUser(user, [sort: 'title', order: order])
        }

        render (view: 'index', model: [
                videoAssetList: videoAssetList
        ])
    }

    def filter()
    {
        def videoAssetList = [:]

        def name        = params.filterVideoName
        def director    = params.filterVideoDir
        def year        = params.int('filterVideoYear')

        if(!name && !director && !year)
        {
            videoAssetList = VideoAsset.findAll()
        }else
        {
            videoAssetList = VideoAsset.findAllByTitleOrDirectorOrYear(name, director, year)
        }

        render (view: 'index', model: [
                videoAssetList: videoAssetList
        ])
    }

    //Scaffold Functions

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VideoAsset.list(params), model:[videoAssetCount: VideoAsset.count()]
    }

    def show(VideoAsset videoAsset) {
        respond videoAsset
    }

    def create() {

        def user        = springSecurityService.currentUser

        def videoAsset = new VideoAsset(params)
            videoAsset.inserted = new Date()
            videoAsset.user = user

        respond videoAsset
    }

    @Transactional
    def save(VideoAsset videoAsset) {
        if (videoAsset == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (videoAsset.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond videoAsset.errors, view:'create'
            return
        }

        videoAsset.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'videoAsset.label', default: 'VideoAsset'), videoAsset.id])
                redirect (uri: "/")
            }
            '*' { respond videoAsset, [status: CREATED] }
        }
    }

    def edit(VideoAsset videoAsset) {
        respond videoAsset
    }

    @Transactional
    def update(VideoAsset videoAsset) {
        if (videoAsset == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (videoAsset.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond videoAsset.errors, view:'edit'
            return
        }

        videoAsset.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'videoAsset.label', default: 'VideoAsset'), videoAsset.id])
                redirect (uri: "/")
            }
            '*'{ respond videoAsset, [status: OK] }
        }
    }

    @Transactional
    def delete(VideoAsset videoAsset) {

        if (videoAsset == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        videoAsset.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'videoAsset.label', default: 'VideoAsset'), videoAsset.id])
                redirect (uri: "/")
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'videoAsset.label', default: 'VideoAsset'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
