package ftexternalmedia

class TestLastFMRestServiceController {

    def lastFMService

    def renderGetMetaByArtist(){

        render lastFMService.getMetaByArtist("Red Hot Chili Peppers")
    }

    def renderGetMetaByTrack(){

        render lastFMService.getMetaByTrack("Eminem" ,"The real slim shady")
    }
}