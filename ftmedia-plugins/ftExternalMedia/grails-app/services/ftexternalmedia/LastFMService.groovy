package ftexternalmedia



import grails.transaction.Transactional
import org.grails.web.json.JSONObject

@Transactional
class LastFMService {

    def restService
    def apiKey = "5ee677913332bd31fe21f79b15c8129a"
    def url = "http://ws.audioscrobbler.com/2.0/?"

    Map<String,String> getMetaByArtist(String nameArtist) {

        HashMap params = new HashMap()
        params.put("artist",  nameArtist)
        params.put("api_key",  apiKey)
        params.put("autocorrect",  1)
        params.put("format",  "json")
        params.put("method",  "artist.getinfo")

        JSONObject json = restService.getRequest(url ,params)

        Map metaMap = new HashMap()
        metaMap.put("Name",json.artist.name)
        metaMap.put("Vita",json.artist.bio.summary)
        metaMap.put("Hörer",json.artist.stats.listeners)
        def similarArtists = ""
        json.artist.similar.artist.each{
            entry ->
                similarArtists <<= entry.name
                if(entry != json.artist.similar.artist.last()){
                    similarArtists <<= ", "
                }
        }
        metaMap.put("Ähnlich",similarArtists)


        return metaMap
    }

    Map<String,String> getMetaByTrack(String nameArtist ,nameTrack) {

        HashMap params = new HashMap()
        params.put("artist",  nameArtist)
        params.put("track",  nameTrack)
        params.put("api_key",  apiKey)
        params.put("autocorrect",  1)
        params.put("format",  "json")
        params.put("method",  "track.getInfo")

        JSONObject json = restService.getRequest(url ,params)
        Map metaMap = new HashMap()
        metaMap.put("Titel",json.track.name)
        metaMap.put("Interpret",json.track.artist.name)
        metaMap.put("Album",json.track.album.title)
        metaMap.put("Album-Bild",json.track.album.image[0].get("#text"))
        metaMap.put("Aufrufe",json.track.playcount)
        metaMap.put("Zuhörer",json.track.listeners)
        def toptags = ""
        json.track.toptags.tag.each{
            tag ->
                toptags <<= tag.get("name")
                if(tag != json.track.toptags.tag.last()){
                    toptags <<= ", "
                }

        }
        metaMap.put("Genre-Tags",toptags)
        metaMap.put("lastFM-Link",json.track.url)

        return metaMap
    }
}
