package ftlibrary

class LibraryController
{
    static allowedMethods = [editProfile:['POST', 'GET']]

    def upload()
    {
        String type = params?.type ?: ''

        render (view: 'upload', model: [
                'type' : type
        ])

    }

    def scan()
    {
        println('Test' + params)

        def type = params.type
        def path = params.path

        if(path == '' || path == null)
        {
            flash.error = "Der ausgewählte Pfad ist ungültig"
        }else
        {
            switch(type.toLowerCase())
            {
                case 'movie':

                    LibraryService.scanMovies(path)
                    flash.message = "Movies successfull scanned"

                    break;
               case 'series':

                    LibraryService.scanSeries(path)
                    flash.message = "Movies successfull scanned"

                    break;

                case 'music':

                    LibraryService.scanMusic(path)
                    flash.message = "Movies successfull scanned"

                    /*def ts = new Date()
                    render(LibraryService.scanMusic())
                    ts = new Date() - ts
                    render('Duration: ' + ts)
                    render('Scanning music')*/

                    break;

                default:
                    redirect(uri: '/')
                    break;

            }
        }


        redirect(uri: '/')
    }
}
