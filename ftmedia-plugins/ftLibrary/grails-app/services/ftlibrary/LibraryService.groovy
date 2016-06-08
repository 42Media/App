package ftlibrary

import ftcore.FileObject
import ftcore.MediaAsset
import ftcore.MediaType
import ftlibrary.ScanFSService
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
        return 42
    }


    private static VideoAsset addMovie(Map movieParams)
    {
        def movie

        movie = new VideoAsset(movieParams)
        movie.save(flush: true)
        if(!movie)
            println(movie.errors.getAllErrors())
        else
            println('Movie saved')
    }

    private static FileObject addFile(Map fileParams)
    {
        def file
        file = new FileObject(fileParams)
        file.save(flush: true)

    }

    private static MediaAsset addMediaAsset(Map mediaAssetParams)
    {
        def mediaAsset
        mediaAsset = new MediaAsset(mediaAssetParams)
        mediaAsset.save(flush: true)
    }

    private static boolean processMovieItem(File file)
    {
        println('Processing: ' + file)

        def Map fileParams
        def FileObject fileObject
        def Map mediaAssetParams
        def MediaAsset mediaAsset
        def Map assetParams
        def VideoAsset asset


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

        try
        {
            mediaAssetParams.put 'file', fileObject
            mediaAssetParams.put 'type', MediaType.MOVIE
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

        FileObject && MediaAsset && asset
    }
}
