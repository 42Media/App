package ftlibrary

import ftexternalmedia.LastFMService

class MusicService {


    ArrayList listArtists(Boolean onlyAlbumArtists) {
        List<String> artistList
        List data = new ArrayList()
        LastFMService lastFM = new LastFMService()


        String criteria = onlyAlbumArtists ? "albumArtist" : "trackArtist"

        artistList = MusicAsset.withCriteria {
            projections {
                distinct(criteria)
            }
        }


        artistList.each {
            artist ->
                Map dataMap = new HashMap()
                dataMap.put("Name", artist)
                try
                {
                    dataMap << lastFM.getMetaByArtist(artist)
                }
                catch (Exception e)
                {
                    println(e.getMessage())
                }

                data.add(dataMap)
        }
        data
    }

    ArrayList listReleases(Map params)
    {
        List data = new ArrayList()
        LastFMService lastFM = new LastFMService()
        Integer max
        if(params?.containsKey('max'))
            max = Math.min(params.max ?: 10, 100)

        String hqlQuery = "select distinct albumArtist, release, releaseType, year, mbReleaseID from MusicAsset "
        if(params?.containsKey('artist'))
            hqlQuery+= "where albumArtist='" + params.artist + "' "
        hqlQuery+= "order by albumArtist, year, release"
        def result = MusicAsset.executeQuery(hqlQuery, [max: max])

        result.each {
            row ->
                Map entry = [:]
                entry.put "Artist",     row[0]
                entry.put "Release",    row[1]
                entry.put "Type",       row[2]
                entry.put "Year",       row[3].toString().substring(0,4)
                entry.put "MBID",       row[4]
                if(row[4])
                {
                    def metaMap
                    try {
                        metaMap = lastFM.getMetaByAlbum([mbid: row[4]])
                        entry << metaMap
                    }
                    catch (Exception e)
                    {
                        println(e.getMessage())
                    }
                }

                data.add(entry)
        }
        data
    }

    HashMap getRelease(String mbReleaseID)
    {
        Map data = new HashMap()
        assert mbReleaseID.length() > 10
        List tracks = new ArrayList()
        LastFMService lastFM = new LastFMService()

        String hqlQuery =
                "select distinct discNumber, trackNumber, title, trackArtist, runTime, release, albumArtist from MusicAsset " +
                        "where mbReleaseID = '" + mbReleaseID + "' order by discNumber, trackNumber"
        def result = MusicAsset.executeQuery(hqlQuery)

        result.each {
            track ->
                Map trackData = [:]
                trackData.put   "discNumber", track[0]
                trackData.put   "trackNumber", track[1]
                trackData.put   "title", track[2]
                trackData.put   "trackArtist", track[3]
                trackData.put   "runTime", track[4]
                trackData.put   "release", track[5]
                trackData.put   "albumArtist", track[6]
                trackData.put   "displayNr", sprintf('%02d-%02d', track[0], track[1])
                tracks.add(trackData)
        }

        try
        {
            def metaData = lastFM.getMetaByAlbum([mbid: mbReleaseID])
            data.put "metaData", metaData
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }


        data.put "tracks", tracks
        data
    }
}