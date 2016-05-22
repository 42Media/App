package ftLibrary

import ftCore.MediaAsset

/**
 @author:    dheenemann
 @version:   0.1
 @date:      2016-05-22
 */

class MusicAsset
{

    String      title
    String      trackArtist
    String      trackArtistSort
    String      albumArtist
    String      albumArtistSort
    String      label
    String      country
    String      releaseType

    int         trackNumber
    int         year
    int         discNumber
    int         runTime
    int         mbAlbumArtistID
    int         mbArtistID
    int         mbReleaseGroupID
    int         mbReleaseID

    MediaAsset mediaAsset

    static constraints =
    {
        trackArtist display:false, nullable: true, blank: true
        trackArtistSort display:false, nullable: true, blank: true
        albumArtist display:false, nullable: true, blank: true
        albumArtistSort display:false, nullable: true, blank: true
        label display:false, nullable: true, blank: true
        country display:false, nullable: true, blank: true
        releaseType display:false, nullable: true, blank: true
        trackNumber display:false, nullable: true, blank: true
        year display:false, nullable: true, blank: true
        discNumber display:false, nullable: true, blank: true
        runTime display:false, nullable: true, blank: true
        mbAlbumArtistID display:false, nullable: true, blank: true
        mbArtistID display:false, nullable: true, blank: true
        mbReleaseGroupID display:false, nullable: true, blank: true
        mbReleaseID display:false, nullable: true, blank: true
        mediaAsset display:false, nullable: true, blank: true
    }

    String toString()
    {
        return title
    }
}
