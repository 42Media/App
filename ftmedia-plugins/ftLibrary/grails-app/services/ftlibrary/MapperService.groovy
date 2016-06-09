package ftlibrary
import ftlibrary.VideoAsset
import grails.transaction.Transactional
import groovy.util.slurpersupport.GPathResult
import groovy.util.slurpersupport.NodeChildren
import org.grails.core.DefaultGrailsDomainClass
import org.jaudiotagger.audio.AudioFile
import org.jaudiotagger.audio.AudioFileIO
import org.jaudiotagger.audio.mp3.MP3File
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.KeyNotFoundException
import org.jaudiotagger.tag.Tag
import org.jaudiotagger.tag.TagField
import org.jaudiotagger.tag.id3.ID3v24FieldKey
import org.jaudiotagger.tag.id3.ID3v24Tag

import java.nio.file.Files

@Transactional
class MapperService {

    static Map mapMovieNfo(File nfo)
    {
        Map param = [:]
        GPathResult data = new XmlSlurper().parse(nfo)

        def properties = new DefaultGrailsDomainClass(VideoAsset.class).persistentProperties

        properties.each
                {
                    if(it.name && data?.(it.name.toLowerCase()))
                    {

                        def key = it.name
                        def targetType = it.getTypePropertyName()
                        def value = data?.(key.toLowerCase())
                        if(value.text().size())
                            param.put(key,  cast(value, targetType))
                    }

                }

        return param
    }

    static Map mapFile(File src)
    {
        def path = src.toPath()
        def Map params = [:]

        params.put 'creator', Files?.getOwner(path).toString()
        params.put 'lastModified', new Date(Files?.getLastModifiedTime(path).toMillis())
        params.put 'size', Files?.size(path).intValue()
        params.put 'name', path?.fileName.toString()
        params.put 'path', path?.parent.toString()
        params.put 'extension', path?.fileName.toString().split('\\.')[-1].toLowerCase()
        params.put 'checksum', new Date().toString()

        if(params.size() != 7)
            throw new Exception('Error mapping file attributes')

        return params
    }

    static Map mapMP3Tags(File mp3)
    {
        Map params = [:]

        def MP3File file = AudioFileIO.read(mp3)
        def ID3v24Tag tag

        if(!file.hasID3v2Tag())
            return params

        tag = file.getID3v2TagAsv24()

        try {params.put  'title', tag.getFirst(ID3v24FieldKey.TITLE).toString()}
        catch (KeyNotFoundException e){params.put 'title', ''}

        try {params.put  'trackArtist', tag.getFirst(ID3v24FieldKey.ARTIST).toString()}
        catch (KeyNotFoundException e){params.put 'trackArtist', ''}

        try {params.put  'trackArtistSort', tag.getFirst(ID3v24FieldKey.ARTIST_SORT).toString()}
        catch (KeyNotFoundException e) {params.put 'trackArtistSort', params?.trackArtist}

        try {params.put  'albumArtist', tag.getFirst(ID3v24FieldKey.ALBUM_ARTIST).toString()}
        catch (KeyNotFoundException e) {params.put 'albumArtist', ''}

        try {params.put  'albumArtistSort', tag.getFirst(ID3v24FieldKey.ALBUM_ARTIST_SORT).toString()}
        catch (KeyNotFoundException e) {params.put 'albumArtistSort', params?.albumArtist}

        try {params.put  'label', tag.getFirst(ID3v24FieldKey.RECORD_LABEL).toString()}
        catch (KeyNotFoundException e) {params.put  'label', ''}

        try {params.put  'country',  tag.getFirst(ID3v24FieldKey.MUSICBRAINZ_RELEASE_COUNTRY).toString()}
        catch (KeyNotFoundException e) {params.put  'country', ''}

        try {params.put  'releaseType', tag.getFirst(ID3v24FieldKey.MUSICBRAINZ_RELEASE_TYPE).toString()}
        catch (KeyNotFoundException e) {params.put  'releaseType', ''}

        try {params.put  'trackNumber', tag.getFirst(ID3v24FieldKey.TRACK).toInteger()}
        catch (KeyNotFoundException e) {params.put  'trackNumber', -1}

        try {params.put  'year', tag.getFirst(ID3v24FieldKey.YEAR).toString()}
        catch (KeyNotFoundException e) {params.put  'year', ''}

        try {params.put  'discNumber', tag.getFirst(ID3v24FieldKey.DISC_NO).toInteger()}
        catch (KeyNotFoundException e) {params.put  'discNumber', 1}

        try {params.put  'mbArtistID', tag.getFirst(ID3v24FieldKey.MUSICBRAINZ_ARTISTID).toString()}
        catch (KeyNotFoundException e) {params.put  'mbArtistID', ''}

        try {params.put  'mbAlbumArtistID', tag.getFirst(ID3v24FieldKey.MUSICBRAINZ_RELEASEARTISTID).toString()}
        catch (KeyNotFoundException e) {params.put  'mbAlbumArtistID', params?.mbArtistID}

        try {params.put  'mbReleaseID', tag.getFirst(ID3v24FieldKey.MUSICBRAINZ_RELEASEID).toString()}
        catch (KeyNotFoundException e) {params.put  'mbReleaseID', ''}

        try {params.put  'mbTrackID', tag.getFirst(ID3v24FieldKey.MUSICBRAINZ_TRACK_ID).toString()}
        catch (KeyNotFoundException e) {params.put  'mbTrackID', ''}

        try {params.put 'release',  tag.getFirst(ID3v24FieldKey.ALBUM).toString()}
        catch (KeyNotFoundException e) {params.put  'release', ''}

        try {params.put 'runTime', file.getMP3AudioHeader().getTrackLength()}
        catch (KeyNotFoundException e) {params.put  'runTime', -1}

        return params
    }

    static cast(NodeChildren node, String targetType)
    {
        assert !node.isEmpty()
        switch(targetType)
        {
            case 'int':
                return node?.toInteger(); break;
            case 'double':
                return node.toDouble(); break;
            case 'float':
                return node.toFloat(); break;
            case 'string':
                return node.toString(); break;
            case 'boolean':
                return node.toBoolean(); break;
            case 'list':
                return node.toList(); break;
            default:
                return node.text();
        }
    }

}