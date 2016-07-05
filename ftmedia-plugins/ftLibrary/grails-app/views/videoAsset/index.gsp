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
                <div class="sidebar">
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
                <div class="movieList assetList">
                    <h4>Filme</h4>
                    <ul>
                        <g:each in="${videoAssetList}" var="video">
                            <li>
                                <a data-toggle="modal" href="/video/show/${video.id}" data-target="#modal-video">
                                    <img src="/coverArt/show/${video.cover.id}" />
                                    <h3>
                                        ${video.title}
                                        <g:if test="${video.year}">
                                            &nbsp;(${video.year})
                                        </g:if>
                                    </h3>
                                </a>
                            </li>
                        </g:each>
                    </ul>
                    <div class="pagination">
                        <g:paginate total="${videoAssetCount ?: 0}" />
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                </div>
            </div>
        </div>
    </body>
</html>