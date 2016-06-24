<!DOCTYPE html>
<html>
    <head>
        <title>Pfad auswählen</title>
    </head>
    <body>
        <div id="edit-videoAsset" class="content scaffold-edit" role="main">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.videoAsset}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.videoAsset}" var="error">
                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form controller="library" method="POST">
                <input type="hidden" name="type" value="${type}">
                <label>Pfad auswählen </label> <br>
                <g:textField name="path"/><br/><br>
                <g:actionSubmit class="btn btn-primary" value="Save" action="scan"/>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </g:form>
        </div>
    </body>
</html>
