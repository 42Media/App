package ftexternalmedia

import org.grails.web.json.JSONObject
import org.springframework.web.client.ResourceAccessException

import java.lang.reflect.GenericSignatureFormatError

class LastFMService {

    def restService
    def apiKey = "5ee677913332bd31fe21f79b15c8129a"
    def url = "http://ws.audioscrobbler.com/2.0/?"

    Map<String,String> getMetaByArtist(String nameArtist) throws ResourceAccessException
    {

        JSONObject json
        HashMap params = new HashMap()
        params.put("artist",  nameArtist)
        params.put("api_key",  apiKey)
        params.put("autocorrect",  1)
        params.put("format",  "json")
        params.put("method",  "artist.getinfo")

        try
        {
            json = restService.getRequest(url ,params)
        }
        catch (ResourceAccessException e)
        {
            println(e.getMessage())
        }

        Map metaMap = new HashMap()
        metaMap.put("Name",json.artist.name)
        metaMap.put("Vita",json.artist.bio.summary)
        metaMap.put("Hörer",json.artist.stats.listeners)
        /* Ähnliche Künstler */
        def similarArtists = ""
        json.artist.similar.artist.each{
            entry ->
                similarArtists <<= entry.name
                if(entry != json.artist.similar.artist.last()){
                    similarArtists <<= ", "
                }
        }
        metaMap.put("Ähnlich",similarArtists)
        /* Bilder */
        metaMap.put("Bild",json.artist.image.last().get('#text'))

        return metaMap
    }

    Map<String,String> getMetaByTrack(String nameArtist ,nameTrack)
    {

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
        metaMap.put("AlbumArt",json.track.album.image[0].get("#text"))
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

    /*
    @author:    at
    @date:      2016-06-28
    @version:   0.1
     */
    Map<String, String> getMetaByAlbum(Map<String, String> callParams) throws GenericSignatureFormatError
    {
        HashMap params = new HashMap()
        params.put("api_key",  apiKey)
        params.put("autocorrect",  1)
        params.put("format",  "json")
        params.put("method",  "album.getInfo")

        if(callParams.containsKey('mbid'))
        {
            params.put("mbid", callParams.mbid)
        }
        else if(callParams.containsKey("artist") && callParams.containsKey("release"))
        {
            params.put("artist",  callParams.artist)
            params.put("album",  callParams.release)
        }
        else
        {
            throw new GenericSignatureFormatError("getMetaByAlbum wurde falsch aufgerufen")
        }

        JSONObject json
        try
        {
            json = restService.getRequest(url ,params)
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }

        Map metaMap = new HashMap()

        metaMap.put("Albumkünstler", json.album.artist)
        metaMap.put("Albumtitel", json.album.name)
        metaMap.put("AlbumArt", json.album.image.last().get('#text'))
        metaMap.put("Aufrufe",json.album.playcount)
        metaMap.put("Zuhörer",json.album.listeners)
        def toptags = ""
        json.album.tags.tag.each{
            tag ->
                toptags <<= tag.get("name")
                if(tag != json.album.tags.tag.last()){
                    toptags <<= ", "
                }

        }
        metaMap.put("Tags",toptags)
        metaMap.put("Link",json.album.url)
        metaMap.put("ReleaseDate", json.album.releasedate)
        metaMap
    }
}
