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
                <div class="col-md-10">
                    <h4>Filme</h4>
                    <div class="col-md-2">
                        Film 1
                    </div>
                    <div class="col-md-2">
                        Film 2
                    </div>
                    <div class="col-md-2">
                        Film 3
                    </div>
                    <div class="col-md-2">
                        Film 4
                    </div>
                    <div class="col-md-2">
                        Film 5
                    </div>
                    <div class="col-md-2">
                        Film 6
                    </div>
                    <div class="col-md-2">
                        Film 7
                    </div>
                    <div class="col-md-2">
                        Film 8
                    </div>
                    <div class="col-md-2">
                        Film 9
                    </div>
                    <div class="col-md-2">
                        Film 10
                    </div>
                    <div class="col-md-2">
                        Film 11
                    </div>
                    <div class="col-md-2">
                        Film 12
                    </div>
                    <div class="col-md-2">
                        Film 13
                    </div>
                    <div class="col-md-2">
                        Film 14
                    </div>
                    <div class="col-md-2">
                        Film 15
                    </div>
                    <div class="col-md-2">
                        Film 16
                    </div>
                    <div class="col-md-2">
                        Film 17
                    </div>
                    <div class="col-md-2">
                        Film 18
                    </div>
                    <div class="col-md-2">
                        Film 19
                    </div>
                    <div class="col-md-2">
                        Film 20
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