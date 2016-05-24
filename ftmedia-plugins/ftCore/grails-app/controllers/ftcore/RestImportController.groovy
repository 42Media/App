package ftcore

import grails.converters.JSON
import org.grails.web.json.JSONObject
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse


class RestImportController {

    def index() {

        JSONObject jsonObject = new JSONObject()
        jsonObject.put("userId",  "1")
        def resp = postService("http://jsonplaceholder.typicode.com/posts", jsonObject)?.json
        render resp as JSON
    }

    public static RestResponse postService(String url, def jsonObject){
        RestResponse rResponse = new RestBuilder().post(url){
            accept("application/json")
        }
        return rResponse
    }
}
