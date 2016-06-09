<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
<div class="row">
    <div class="col-xs-4"><h3>Historie</h3></div>
    <div class="col-xs-2">
        <div class="text-center">
            <h4>Herr der Ringe 2</h4>
            <div class="progress">
                <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;">
                    60%

                </div>
            </div>
            <h4><asset:image src="symbole/play.png" width="15%"/></h4>
        </div>
    </div>
    <div class="col-xs-2">
        <h4>Herr der Ringe</h4>
        <h4>gesehen am: 10.05.16</h4>

    </div>
    <div class="col-xs-2">
        <h4>Herr der Ringe 3 hinzugef&uuml;gt</h4>
    </div>
    <div class="col-xs-2">
        <h4>Herr der Ringe 2 hinzugef&uuml;gt</h4>
    </div>
</div>
<div style="margin-top: 50px"></div>
<div class="row">
    <div class="col-xs-4"><a href="/video/index"><h3>Filme</h3></a></div>
    <div class="col-xs-7">
        <g:if test="${videoList.isEmpty()}">
            <h3>Keine Filminhalte vorhanden</h3>
        </g:if>

        <g:each in="${videoList}" var="video">
            <h3><a data-toggle="modal" href="/video/show/${video.id}" data-target="#modal">${video.title}</a></h3>
        </g:each>

    </div>
    <div class="col-xs-1"><h3><a data-toggle="modal" href="/video/create" data-target="#modal"><asset:image src="symbole/kreuz.png" /></a></h3></div>
</div>
<div style="margin-top: 30px"></div>
<div class="row">
    <div class="col-xs-4"><a href="/music/index"><h3>Musik</h3></a></div>
    <div class="col-xs-7">
        <g:if test="${musicList.isEmpty()}">
            <h3>Keine Musikinhalte vorhanden</h3>
        </g:if>

        <g:each in="${musicList}" var="music">
            <h3><a data-toggle="modal" href="/music/show/${music.id}" data-target="#modal">${music.title}</a></h3>
        </g:each>
    </div>
    <div class="col-xs-1"><h3><a data-toggle="modal" href="/music/create" data-target="#modal"><asset:image src="symbole/kreuz.png" /></a></h3></div>
</div>
<div style="margin-top: 50px"></div>
<div class="row">
    <div class="col-xs-4"><h3>Weitere Medien</h3></div>
    <div class="col-xs-2"><h3>NAS</h3></div>
    <div class="col-xs-2"><h3>Cloud</h3></div>
    <div class="col-xs-2"><h3>TV-Programm</h3></div>
    <div class="col-xs-1"><h3>&nbsp;</h3></div>
    <div class="col-xs-1"><h3><asset:image src="symbole/kreuz.png" /></h3></div>
</div>

<!-- Modal -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        </div>
    </div>
</div>
</body>
</html>