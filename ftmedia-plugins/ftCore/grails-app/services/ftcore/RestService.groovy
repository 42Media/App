package ftcore

import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

class RestService {

    def getRequest(def url, def params) {


        url = url + params.collect { it }.join('&')

        RestBuilder builder = new RestBuilder(connectTimeout:100)
        RestResponse rResponse = builder.get(url){
            accept("application/json")
        }

        return rResponse.json
    }
}
