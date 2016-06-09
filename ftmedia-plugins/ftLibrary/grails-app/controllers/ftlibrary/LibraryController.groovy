package ftlibrary

class LibraryController {

    def scan()
    {
        render('Calling: library.scan()<br />')
        String type = params?.type ?: ''

        switch(type.toLowerCase())
        {
            case 'movie':
                render('Scanning movies...')
                render(LibraryService.scanMovies() + " movies scanned")
                break;
            case 'series':
                render(LibraryService.scanSeries())
                render('Scanning series')
                break;
            case 'music':
                def ts = new Date()
                render(LibraryService.scanMusic())
                ts = new Date() - ts
                render('Duration: ' + ts)
                render('Scanning music')
                break;
            default:
                render('Scanning all')
                break;
        }
    }
}
