<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'videoAsset.label', default: 'VideoAsset')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a data-toggle="modal" href="/video/create" data-target="#modal"><b>Filme hinzuf&uuml;gen</b></a></li>
                        <li><a href="/video/showLast"><b>Zuletzt hinzuf&uuml;gt</b></a></li>
                        <li><a href="#">Beste Bewertung</a></li>
                        <li><a href="#">Bereits gesehen</a></li>
                    </ul>
                    <h4>Filter</h4>
                    <ul class="nav nav-sidebar">
                        <g:form controller="videoAsset" method="POST">
                            <li><input type="text" class="form-control" name="filterVideoName" placeholder="Name" /></li>
                            <li><input type="text" class="form-control" name="filterVideoDir" placeholder="Regisseur" /></li>
                            <li><input type="text" class="form-control" name="filterVideoYear" placeholder="Jahr" /></li>
                            <br>
                            <g:actionSubmit class="btn btn-success" value="Filtern" action="filter"/>
                        </g:form>
                    </ul>
                    <h4>Sortierung</h4>
                    <ul class="nav nav-sidebar">
                        Datum&nbsp;<a class="btn btn-default" href="/video/sort?tag=inserted&order=desc"> \/ </a> <a class="btn btn-default" href="/video/sort?tag=inserted&order=asc"> /\ </a>
                        <br>
                        Titel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-default" href="/video/sort?tag=title&order=desc"> \/ </a> <a class="btn btn-default" href="/video/sort?tag=title&order=asc"> /\ </a>
                    </ul>

                </div>
                <div class="col-md-10">
                    <h4>Filme</h4>
                    <g:each in="${videoAssetList}" var="video">
                        <div class="col-md-2">
                            <a data-toggle="modal" href="/video/show/${video.id}" data-target="#modal-music">${video.title}</a>
                        </div>
                    </g:each>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                </div>
            </div>
        </div>

    <!--
        <a href="#list-videoAsset" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-videoAsset" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${videoAssetList}" />

            <div class="pagination">
                <g:paginate total="${videoAssetCount ?: 0}" />
            </div>
        </div>-->
    </body>
</html>