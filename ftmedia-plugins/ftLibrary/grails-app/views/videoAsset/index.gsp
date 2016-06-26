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
                        <li><a data-toggle="modal" href="/video/create" data-target="#modal">Filme hinzuf&uuml;gen</a></li>
                        <li><a href="#">Zuletzt hinzuf&uuml;gt</a></li>
                        <li><a href="#">Beste Bewertung</a></li>
                        <li><a href="#">Bereits gesehen</a></li>
                    </ul>
                    <h4>Filter</h4>
                    <ul class="nav nav-sidebar">
                        <li><input type="text" class="form-control" id="filterVideoName" placeholder="Name" /></li>
                        <li><input type="text" class="form-control" id="filterVideoSsp" placeholder="Schauspieler" /></li>
                        <li><input type="text" class="form-control" id="filterVideoReg" placeholder="Regisseur" /></li>
                        <li><input type="text" class="form-control" id="filterVideoGenre" placeholder="Genre" /></li>
                    </ul>
                    <h4>Sortierung</h4>
                    <ul class="nav nav-sidebar">
                        <li>Name&nbsp;&nbsp;<input class="btn btn-default" type="button" id="butVidNameAb" value="\/"><input class="btn btn-default" type="button" id="butVidNameAuf" value="/\"></li>
                        <li>Datum&nbsp;<input class="btn btn-default" type="button" id="butVidDatumAb" value="\/"><input class="btn btn-default" type="button" id="butVidDatumAuf" value="/\"></li>
                    </ul>

                </div>
                <div class="movieList">
                    <h4>Filme</h4>
                    <ul>
                        <g:each in="${videoAssetList}" var="video">
                            <li>
                            <a data-toggle="modal" href="/video/show/${video.id}" data-target="#modal-video">
                                <img src="/coverArt/show/${video.id}" />
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