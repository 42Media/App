<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'musicAsset.label', default: 'MusicAsset')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a data-toggle="modal" href="/music/create" data-target="#modal">Musik hinzuf&uuml;gen</a></li>
                        <li><a href="#">Zuletzt hinzuf&uuml;gt</a></li>
                        <li><a href="#">Beste Bewertung</a></li>
                        <li><a href="#">Bereits geh&ouml;rt</a></li>
                    </ul>
                    <h4>Filter</h4>
                    <ul class="nav nav-sidebar">
                        <li><input type="text" class="form-control" id="filterMusicAlbum" placeholder="Album" /></li>
                        <li><input type="text" class="form-control" id="filterMusicSaenger" placeholder="S&auml;nger" /></li>
                        <li><input type="text" class="form-control" id="filterMusicProd" placeholder="Produzent" /></li>
                        <li><input type="text" class="form-control" id="filterMusicGenre" placeholder="Genre" /></li>
                    </ul>
                    <h4>Sortierung</h4>
                    <ul class="nav nav-sidebar">
                        <li>Name&nbsp;&nbsp;<input class="btn btn-default" type="button" id="butMusNameAb" value="\/"><input class="btn btn-default" type="button" id="butMusNameAuf" value="/\"></li>
                        <li>Datum&nbsp;<input class="btn btn-default" type="button" id="butMusDatumAb" value="\/"><input class="btn btn-default" type="button" id="butMusDatumAuf" value="/\"></li>
                    </ul>

                </div>
                <div class="col-md-10">
                    <h4>Musikalben</h4>
                    <div class="col-md-2">
                        Titel 1
                    </div>
                    <div class="col-md-2">
                        Titel 2
                    </div>
                    <div class="col-md-2">
                        Titel 3
                    </div>
                    <div class="col-md-2">
                        Titel 4
                    </div>
                    <div class="col-md-2">
                        Titel 5
                    </div>
                    <div class="col-md-2">
                        Titel 6
                    </div>
                    <div class="col-md-2">
                        Titel 7
                    </div>
                    <div class="col-md-2">
                        Titel 8
                    </div>
                    <div class="col-md-2">
                        Titel 9
                    </div>
                    <div class="col-md-2">
                        Titel 10
                    </div>
                    <div class="col-md-2">
                        Titel 11
                    </div>
                    <div class="col-md-2">
                        Titel 12
                    </div>
                    <div class="col-md-2">
                        Titel 13
                    </div>
                    <div class="col-md-2">
                        Titel 14
                    </div>
                    <div class="col-md-2">
                        Titel 15
                    </div>
                    <div class="col-md-2">
                        Titel 16
                    </div>
                    <div class="col-md-2">
                        Titel 17
                    </div>
                    <div class="col-md-2">
                        Titel 18
                    </div>
                    <div class="col-md-2">
                        Titel 19
                    </div>
                    <div class="col-md-2">
                        Titel 20
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




<!--
        <a href="#list-musicAsset" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-musicAsset" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${musicAssetList}" />

            <div class="pagination">
                <g:paginate total="${musicAssetCount ?: 0}" />
            </div>
        </div>-->
    </body>
</html>