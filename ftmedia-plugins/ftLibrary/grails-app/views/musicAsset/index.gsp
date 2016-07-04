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
                        <li><a data-toggle="modal" href="/music/create" data-target="#modal"><b>Musik hinzuf&uuml;gen</b></a></li>
                        <li><a href="/music/showLast"><b>Zuletzt hinzuf&uuml;gt</b></a></li>
                        <li><a href="/artist/list"><b>K&uuml;nstler</b></a></li>
                        <li><a href="/release/list"><b>Alben</b></a></li>
                        <li><a href="#">Beste Bewertung</a></li>
                        <li><a href="#">Bereits geh&ouml;rt</a></li>
                    </ul>
                    <h4>Filter</h4>
                    <ul class="nav nav-sidebar">
                        <g:form controller="musicAsset" method="POST">
                            <li><input type="text" class="form-control" name="filterMusicAlbum" placeholder="Album" /></li>
                            <li><input type="text" class="form-control" name="filterMusicSaenger" placeholder="S&auml;nger" /></li>
                            <li><input type="text" class="form-control" name="filterMusicYear" placeholder="Jahr" /></li>
                            <br>
                            <g:actionSubmit class="btn btn-success" value="Filtern" action="filter"/>
                        </g:form>
                    </ul>
                    <h4>Sortierung</h4>
                    <ul class="nav nav-sidebar">

                        Datum&nbsp;<a class="btn btn-default" href="/music/sort?tag=inserted&order=desc"> \/ </a> <a class="btn btn-default" href="/music/sort?tag=inserted&order=asc"> /\ </a>
                        <br>
                        Titel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn btn-default" href="/music/sort?tag=title&order=desc"> \/ </a> <a class="btn btn-default" href="/music/sort?tag=title&order=asc"> /\ </a>

                    </ul>

                </div>
                <div class="col-md-10 trackList">
                    <h4>Titel</h4>
                    <ul>
                    <g:each in="${musicAssetList}" var="music">
                        <li>
                            <a data-toggle="modal" href="/music/show/${music.id}" data-target="#modal-music">${music.title}</a>
                        </li>
                    </g:each>
                    </ul>
                    <div class="pagination">
                        <g:paginate total="${musicAssetCount ?: 0}" />
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