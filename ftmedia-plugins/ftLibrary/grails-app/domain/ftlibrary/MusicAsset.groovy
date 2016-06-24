package ftlibrary

import ftcore.*

/**
 @author:    atzscherlich
 @version:   0.3
 @date:      2016-05-27
 */

class MusicAsset
{

    String      title
    String      release
    String      trackArtist
    String      trackArtistSort
    String      albumArtist
    String      albumArtistSort
    String      label
    String      country
    String      releaseType
    String        year
    String         mbAlbumArtistID
    String         mbArtistID
    String         mbTrackID
    String         mbReleaseID
    
    int         trackNumber
    int         discNumber
    int         runTime

    Date inserted

    Image       cover

    static hasMany = {
        mediaAsset:MediaAsset
    }

    static constraints =
    {
        trackArtist nullable: true, blank: true
        trackArtistSort display:false, nullable: true, blank: true
        albumArtist display:false, nullable: true, blank: true
        albumArtistSort display:false, nullable: true, blank: true
        label display:false, nullable: true, blank: true
        country display:false, nullable: true, blank: true
        releaseType display:false, nullable: true, blank: true
        trackNumber display:false, nullable: true, blank: true
        year display:true, nullable: true, blank: true
        discNumber display:false, nullable: true, blank: true
        runTime display:false, nullable: true, blank: true
        mbAlbumArtistID display:false, nullable: true, blank: true
        mbArtistID display:false, nullable: true, blank: true
        mbTrackID display:false, nullable: true, blank: true
        mbReleaseID display:false, nullable: true, blank: true
        cover display:false, nullable:true, blank:true
        inserted display: true, nullable: true, blank: true
    }

    String toString()
    {
        return title
    }
}
