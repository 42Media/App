package ftlibrary

import ftcore.FileObject
import ftlibrary.VideoAsset
import grails.transaction.Transactional
import groovy.io.FileType

@Transactional
class ScanFSService {

    static Map<String, File> getMovies(String baseDir)
    {
        def File dir = new File(baseDir)
        def types = ['.avi', '.mpg', '.mpeg', '.mkv', '.mp4','.m4v', '.wmv']
        def Map result = [:]

        assert dir.isDirectory() == true

        dir.eachFileRecurse(FileType.FILES)
                {
                    file ->
                        types.each
                                {
                                    ext -> if(file.name.endsWith(ext))
                                    {
                                        def path = file.path.toString().replace(file.name, '')
                                        def folder = path.tokenize('\\').getAt(-1)
                                        result.put(folder, file)
                                    }
                                }
                }

        return result
    }

    static List getNfoFiles(String baseDir)
    {
        getNfoFiles(new File(baseDir))
    }

    static List getNfoFiles(File baseDir)
    {
        getFiles baseDir, ['.nfo']
    }

    static boolean hasNfoFile(FileObject file)
    {
        def String src = file.path
        getNfoFiles(src).size().asBoolean()
    }

    static File getNfoFor(FileObject file)
    {
        def String src = file.path
        def nfo = getNfoFiles(src)
        if(!nfo.size())
            throw new Exception('No nfo available')
        nfo.get(0)

    }

    static List getMediaFiles(String baseDir, String type)
    {
        getMediaFiles(new File(baseDir), type)
    }

    static List getMediaFiles(File baseDir, String type)
    {
        def files = []
        switch(type.toLowerCase()) {
            case 'video':
                files = ['.avi', '.mpg', '.mpeg', '.mkv', '.mp4','.m4v', '.wmv']; break;
            case 'music':
                files = ['.mp3', '.ogg', '.wav', '.flac', '.wma', '.ape']; break;
            case 'picture':
                files = ['.jpg', '.jpeg', '.bmp', '.png', '.gif', '.tif']; break;
        }
        getFiles(baseDir, files)
    }

    private static List getFiles(File baseDir, List type)
    {
        assert baseDir.isDirectory() == true
        assert type.size() > 0

        def files = []

        baseDir.eachFileRecurse(FileType.FILES)
                {   file ->
                    type.each
                            {
                                ext -> if(file.name.endsWith(ext))
                                    files << file
                            }
                }
        return files
    }
}