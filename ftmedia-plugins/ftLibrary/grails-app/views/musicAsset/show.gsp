<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'musicAsset.label', default: 'MusicAsset')}" />
        <title><g:message code="default.show.label" args="[musicAsset]" /></title>
    </head>
    <body>
        <div id="show-musicAsset" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[musicAsset]" /></h1>
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Eigene Daten</div>
                <div class="panel-body">
                    <f:display bean="musicAsset" />
                    <g:form resource="${this.musicAsset}" method="DELETE">
                        <fieldset class="buttons">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <g:link class="edit btn btn-primary"  data-toggle="modal" data-target="#modal-music" action="edit" resource="${this.musicAsset}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                            <input class="delete btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </fieldset>
                    </g:form>
                </div>
            </div>
            <t class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">REST-Daten</div>
                <br class="panel-body">

                    <g:each in="${mapData}" var="data">
                        ${data.key}: ${data.value}</br>
                    </g:each>
                     <g:each in="${mapDataArtist}" var="data">
                        ${data.key}: ${data.value}</br>
                    </g:each>

                </div>
            </div>
        </div>
    </body>
</html>
