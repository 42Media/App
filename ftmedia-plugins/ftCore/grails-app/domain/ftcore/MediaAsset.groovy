package ftcore

/**
 @author:    atzscherlich
 @version:   0.1
 @date:      2016-05-18
 */

class MediaAsset {
    String          id
    Integer         playCount
    Date            lastPlayed
    ParentalRating  parentalRating
    String          tagline

    FileObject      file
    MediaType       type


    static mapping = {
        tagline type: "text"
        id generator: 'uuid'
    }

    static constraints = {
        tagline nullable: true
    }

    String toString()
    {
        return id
    }
}

class MediaType {
    static final String MUSIC = 'Music'
    static final String MOVIE = 'Movie'
    static final String SERIES = 'Series'
    static final String PICTURE = 'Picture'
}

class ParentalRating {
    static final String Y = 'TV-Y'
    static final String Y7 = 'TV-Y7'
    static final String G = 'TV-G'
    static final String PG = 'TV-PG'
    static final String Y14 = 'TV-14'
    static final String MA = 'TV-MA'
}