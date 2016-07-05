package ftlibrary

import ftcore.MediaAsset
import ftcore.security.User

/**
 @author:    atzscherlich
 @version:   0.3
 @date:      2016-06-30
 */

class VideoAsset
{

    String  title
    String  originalTitle
    String  sortTitle
    String  director
    String  studio
    String  country
    String  outline

    String  tagline

    String  plot
    String  source
    Date    inserted
    CoverArt cover

    User    user

    //MediaAsset mediaAsset

    static mapping = {
        plot type: "text"
        outline type: "text"
        tagline type: "text"
        studio type: "text"
    }

    int     year
    int     runtime
    int     imdbID
    int     tmdbID


    static hasMany = {
        mediaAsset:MediaAsset
    }

    static constraints = {
        title unique: ['year', 'director']
        originalTitle display:false, nullable: true, blank: true
        sortTitle display:false, nullable: true, blank: true
        director display:false, nullable: true, blank: true
        studio display:false, nullable: true, blank: true
        country display:false, nullable: true, blank: true
        outline display:false, nullable: true, blank: true
        tagline display:false, nullable: true, blank: true
        year display:false, nullable: true, blank: true
        plot display:false, nullable: true, blank: true
        runtime display:false, nullable: true, blank: true
        imdbID display:false, nullable: true, blank: true
        tmdbID display:false, nullable: true, blank: true
        source display: false, unique: true, maxSize: 255, nullable: true
        cover nullable: true
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