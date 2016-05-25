package ftlibrary

import ftcore.MediaAsset

/**
 @author:    dheenemann
 @version:   0.1
 @date:      2016-05-22
 */

class VideoAsset
{

    String  title
    String  originalTitle
    String  sortTitle
    String  director
    String  studio
    Genre   genre
    String  country
    String  outline
    String  tagline

    int     year
    int     plot
    int     runtime
    int     imdbID
    int     tmdbID

    MediaAsset mediaAsset

    static constraints = {
        originalTitle display:false, nullable: true, blank: true
        sortTitle display:false, nullable: true, blank: true
        director display:false, nullable: true, blank: true
        studio display:false, nullable: true, blank: true
        genre display:false, nullable: true, blank: true
        country display:false, nullable: true, blank: true
        outline display:false, nullable: true, blank: true
        tagline display:false, nullable: true, blank: true
        year display:false, nullable: true, blank: true
        plot display:false, nullable: true, blank: true
        runtime display:false, nullable: true, blank: true
        imdbID display:false, nullable: true, blank: true
        tmdbID display:false, nullable: true, blank: true
        mediaAsset display:false, nullable: true, blank: true
    }

    String toString()
    {
        return title
    }
}

class Genre
{
    static final String THRILLER = 'Thriller'
}


