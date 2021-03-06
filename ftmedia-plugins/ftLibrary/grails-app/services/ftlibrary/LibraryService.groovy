package ftlibrary


import ftcore.security.User
import ftcore.FileObject
import ftcore.MediaAsset
import ftcore.MediaType
import grails.transaction.Transactional

@Transactional
class LibraryService {

    static Integer scanMovies(String src, User user)
    {

        Map scanResult = ScanFSService.getMovies(src)

        scanResult.each
        {
            folder, file ->
                processMovieItem(file, user)
        }

        return scanResult.size()
    }

    static Integer scanSeries(String src)
    {
        return 42
    }

    static Integer scanMusic(String src, User user)
    {
        List<File> scanResult = ScanFSService.getMediaFiles(src, 'Music')
        scanResult.each
        {
            file ->
                processMusicItem(file, user)
        }

        return scanResult.size()
    }


    private static VideoAsset addMovie(Map movieParams)
    {
        def movie

        movie = new VideoAsset(movieParams)
        movie.save(flush: true)
        if(!movie)
            println(movie.errors.getAllErrors())
    }

    private static FileObject addFile(File file)
    {
        def Map fileParams
        def FileObject fileObject

        try
        {
            fileParams = MapperService.mapFile(file)
            fileObject = new FileObject(fileParams)
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }
        finally
        {
            if(fileObject)
                fileObject.save(flush: true)
            println('File saved.')
        }

        fileObject
    }

    private static CoverArt addCover(File cover)
    {
        println('Adding: ' + cover.path)
        Map params = [:]
        params.put 'title', cover.name
        params.put 'path', cover.path
        params.put 'data', cover.bytes

        CoverArt coverArt = new CoverArt(params)
        coverArt.save(flush: true, failOnError: true)

        coverArt
    }

    private static MediaAsset addMediaAsset(Map mediaAssetParams)
    {
        MediaAsset mediaAsset

        try
        {
            mediaAsset = new MediaAsset(mediaAssetParams)
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }
        finally
        {
            if(mediaAsset)
                mediaAsset.save(flush: true)
            println('MediaAsset saved..')
        }

        mediaAsset
    }

    private static boolean processMovieItem(File file, User user)
    {

        println('Processing: ' + file)

        def fileObject  = null
        def coverArt    = null
        def mediaAsset  = null
        def videoAsset  = null

        Map mediaAssetParams    = [:]
        Map assetParams         = [:]

        fileObject = addFile(file)



        mediaAssetParams.put 'file', fileObject
        mediaAssetParams.put 'type', MediaType.MOVIE

        mediaAsset = addMediaAsset(mediaAssetParams)


        try
        {
            File cover = ScanFSService.getCoverFor(fileObject)
            coverArt = addCover(cover)
        }
        catch(Exception e)
        {
            println(e.getMessage())
            coverArt = null
        }

        try
        {
            def nfo = ScanFSService.getNfoFor(fileObject)
            assetParams = MapperService.mapMovieNfo(nfo)
            assetParams.put 'mediaAsset', mediaAsset
            assetParams.put 'cover', coverArt
            assetParams.put 'source', file.path
            videoAsset = new VideoAsset(assetParams)
            videoAsset.inserted = new Date()
            videoAsset.user = user
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }
        finally
        {
            if(videoAsset)
            {
                videoAsset.save(flush: true, failOnError: true)
                println('VideoAsset saved...')
            }

        }

        fileObject && mediaAsset && videoAsset
    }

    private static boolean processMusicItem(File file, User user)
    {

        if(!file.path.endsWith('.mp3'))
            return false
        println('Processing: ' + file)
        println()

        MapperService.mapMP3Tags(file)


        def fileObject = addFile(file)

        def Map mediaAssetParams = [:]

        mediaAssetParams.put 'file', fileObject
        mediaAssetParams.put 'type', MediaType.MUSIC

        def mediaAsset = addMediaAsset(mediaAssetParams)

        def Map assetParams
        def MusicAsset asset

        try
        {
            assetParams = MapperService.mapMP3Tags(file)
            assetParams.put 'mediaAsset', mediaAsset
            asset = new MusicAsset(assetParams)
            asset.inserted = new Date()
            asset.user = user
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }
        finally
        {
            if(asset)
                asset.save(flush: true)
            println('MusicAsset saved...')
        }

        fileObject && mediaAsset && asset
    }
}
