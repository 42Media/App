<!DOCTYPE html>
<html>
    <head>
        <g:set var="entityName" value="${message(code: 'musicAsset.label', default: 'MusicAsset')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div id="edit-musicAsset" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.musicAsset}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.musicAsset}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.musicAsset}" method="PUT">
                <g:hiddenField name="version" value="${this.musicAsset?.version}" />
                <fieldset class="form">
                    <f:all bean="musicAsset"/>
                </fieldset>
                <fieldset class="buttons">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <input class="save btn btn-primary" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
