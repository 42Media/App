package ftcore

import grails.transaction.Transactional
import grails.converters.JSON
import org.grails.web.json.JSONObject
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse

@Transactional
class RestService {

    def postRequest(String url, def jsonObject) {
        RestResponse rResponse = new RestBuilder().post(url){
            accept("application/json")
        }
        return rResponse
    }
}
