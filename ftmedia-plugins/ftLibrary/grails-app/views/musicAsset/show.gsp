<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'musicAsset.label', default: 'MusicAsset')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="show-musicAsset" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <f:display bean="musicAsset" />
            <g:form resource="${this.musicAsset}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit btn btn-primary"  action="edit" resource="${this.musicAsset}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
