<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'videoAsset.label', default: 'VideoAsset')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="show-videoAsset" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[videoAsset]" /></h1>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Eigene Daten</div>
                <div class="panel-body">
                    <f:display bean="videoAsset" />
                    <g:form resource="${this.videoAsset}" method="DELETE">
                        <fieldset class="buttons">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <g:link data-toggle="modal" data-target="#modal-edit" class="edit btn btn-primary" action="edit" resource="${this.videoAsset}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                            <input class="delete btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </fieldset>
                    </g:form>

                </div>
            </div>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">REST-Daten</div>
                <div class="panel-body">

                </div>
            </div>
        </div>
    </body>
</html>
