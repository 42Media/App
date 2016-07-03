package ftmedia

class UrlMappings {

    static mappings = {

        "/"(controller:"main")

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/video/$action?/$id?(.$format)?"(controller:"videoAsset")
        "/music/$action?/$id?(.$format)?"(controller:"musicAsset")


        "/grails"(view:"/index")

        "500"(view:'/main/error')
        "404"(view:'/main/notFound')
    }
}
