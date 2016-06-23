<%@ page import="ftlibrary.CoverArt" %>
<div id="show-coverArt" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.type" args="[CoverArtInstance]" /></h1>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Eigene Daten</div>
        <div class="panel-body">
            <f:display bean="CoverArt" />
            <g:form resource="${ftlibrary.CoverArt}" method="DELETE">
                <img src="${createLink(controller:'CoverArt', action:'showData', ressource:"${this.coverArt}")}" width='300' />
                <fieldset class="buttons">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <g:link class="edit btn btn-primary"  action="edit" resource="${this.coverArt}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete btn btn-danger" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </div>
</div>
