package ftcore

import grails.transaction.Transactional
import grails.converters.JSON
import org.grails.web.json.JSONObject
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse


@Transactional
class RestService {

    def getRequest(def url, def params) {


        url = url + params.collect { it }.join('&')

        RestResponse rResponse = new RestBuilder().get(url){
            accept("application/json")
        }

        return rResponse.json
    }
}
