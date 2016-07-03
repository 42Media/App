package ftlibrary

class CoverArtController {

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CoverArt.list(params), model:[CoverArtInstanceCount: CoverArt.count()]
    }

    def showAll(CoverArt CoverArtInstance) {
        [CoverArtInstance: CoverArtInstance]
    }

    def show(CoverArt CoverArtInstance) {
        // write the image to the output stream
        response.outputStream << CoverArtInstance.data
        response.outputStream.flush()
    }
}
