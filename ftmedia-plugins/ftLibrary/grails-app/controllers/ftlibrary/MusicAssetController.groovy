package ftLibrary

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MusicAssetController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MusicAsset.list(params), model:[musicAssetCount: MusicAsset.count()]
    }

    def show(MusicAsset musicAsset) {
        respond musicAsset
    }

    def create() {
        respond new MusicAsset(params)
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

    def edit(MusicAsset musicAsset) {
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
                redirect musicAsset
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
                redirect action:"index", method:"GET"
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
