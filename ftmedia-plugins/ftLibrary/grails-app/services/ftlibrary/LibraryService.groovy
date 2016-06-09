package ftlibrary
import ftcore.FileObject
import ftcore.MediaAsset
import ftcore.MediaType
import ftlibrary.MusicAsset
import ftlibrary.ScanFSService
import ftlibrary.VideoAsset
import grails.transaction.Transactional

@Transactional
class LibraryService {

    static Integer scanMovies()
    {
        def String src = '\\\\n36l\\filme'
        def Map scanResult = ScanFSService.getMovies(src)

        scanResult.each
        {
            folder, file ->
                processMovieItem(file)
        }

        return scanResult.size()
    }

    static Integer scanSeries()
    {
        return 42
    }

    static Integer scanMusic()
    {
        def String src = '\\\\n36l\\musik\\emby'
        def List<File> scanResult = ScanFSService.getMediaFiles(src, 'Music')
        scanResult.each
        {
            file ->
                processMusicItem(file)
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

    private static MediaAsset addMediaAsset(Map mediaAssetParams)
    {
        def MediaAsset mediaAsset

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

    private static boolean processMovieItem(File file)
    {
        println('Processing: ' + file)

        def fileObject = addFile(file)

        def Map mediaAssetParams = [:]

        mediaAssetParams.put 'file', fileObject
        mediaAssetParams.put 'type', MediaType.MOVIE

        def mediaAsset = addMediaAsset(mediaAssetParams)

        def Map assetParams
        def VideoAsset asset


        try
        {
            def nfo = ScanFSService.getNfoFor(fileObject)
            assetParams = MapperService.mapMovieNfo(nfo)
            assetParams.put 'mediaAsset', mediaAsset
            asset = new VideoAsset(assetParams)
        }
        catch (Exception e)
        {
            println(e.getMessage())
        }
        finally
        {
            if(asset)
                asset.save(flush: true)
            println('VideoAsset saved...')
        }

        fileObject && mediaAsset && asset
    }

    private static boolean processMusicItem(File file)
    {
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
