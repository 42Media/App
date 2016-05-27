package ftlibrary

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VideoAssetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond VideoAsset.list(params), model:[videoAssetCount: VideoAsset.count()]
    }

    def show(VideoAsset videoAsset) {
        respond videoAsset
    }

    def create() {
        respond new VideoAsset(params)
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
                redirect videoAsset
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
