package ftlibrary

import grails.converters.JSON
import grails.transaction.Transactional
import org.grails.web.json.JSONObject

@Transactional
class LastFMService {

    def restService
    def apiKey = "5ee677913332bd31fe21f79b15c8129a"
    def url = "http://ws.audioscrobbler.com/2.0/?"

    JSONObject getMetaByArtist(String nameArtist) {

        HashMap params = new HashMap()
        params.put("artist",  nameArtist)
        params.put("api_key",  apiKey)
        params.put("autocorrect",  1)
        params.put("format",  "json")
        params.put("method",  "artist.gettoptags")

        def resp = restService.getRequest(url ,params)

        return resp
    }

    JSONObject getMetaByTrack(String nameArtist ,nameTrack) {

        HashMap params = new HashMap()
        params.put("artist",  nameArtist)
        params.put("track",  nameTrack)
        params.put("api_key",  apiKey)
        params.put("autocorrect",  1)
        params.put("format",  "json")
        params.put("method",  "track.gettoptags")

        def resp = restService.getRequest(url ,params)

        return resp
    }
}
