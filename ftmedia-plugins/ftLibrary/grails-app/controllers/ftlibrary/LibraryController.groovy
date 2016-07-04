package ftlibrary

class LibraryController
{
    def springSecurityService

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
        def user        = springSecurityService.currentUser

        println('Test' + params)

        def type = params.type
        def path = params.path
        def count

        if(path == '' || path == null)
        {
            flash.error = "Der ausgewählte Pfad ist ungültig"
        }else
        {
            switch(type.toLowerCase())
            {
                case 'movie':

                    count = LibraryService.scanMovies(path, user)
                    flash.message = count + " Movies successfull scanned"

                    break;
               case 'series':

                    count = LibraryService.scanSeries(path)
                    flash.message = count + " Episodes successfull scanned"

                    break;

                case 'music':

                    count = LibraryService.scanMusic(path, user)
                    flash.message = count + " Tracks successfull scanned"

                    break;

                default:
                    redirect(uri: '/')
                    break;

            }
        }


        redirect(uri: '/')
    }
}
