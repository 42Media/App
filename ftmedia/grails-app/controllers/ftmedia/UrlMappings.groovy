package ftmedia

class UrlMappings {

    static mappings = {

        "/"(controller:"main")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }


        "/grails"(view:"/index")

        "500"(view:'/main/error')
        "404"(view:'/main/notFound')
    }
}
