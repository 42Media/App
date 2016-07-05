<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>42Media - Your Media Solution</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
    <asset:stylesheet src="ftmedia.css" />
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
<div class="row start">
    <div class="col-xs-4"><a href="/video/index"><h3>Filme</h3></a></div>
    <div class="col-xs-7 movieList">
        <ul>
            <g:if test="${videoList.isEmpty()}">
                <h3>Keine Filminhalte vorhanden</h3>
            </g:if>

            <g:each in="${videoList}" var="video">
                <a data-toggle="modal" href="/video/show/${video.id}" data-target="#modal-video">
                    <li>
                        <img src="/coverArt/show/${video.cover.id}" />
                        <h3>${video.title}</h3>
                    </li>
                </a>
            </g:each>
        </ul>
    </div>
    <div class="col-xs-1">
        <div style="width: 100px">
            <a data-toggle="modal" href="/video/create" data-target="#modal-video"><asset:image src="symbole/kreuz.png" /></a>
            <a data-toggle="modal" href="/library/upload?type=movie" data-target="#modal-video"><asset:image src="symbole/upload.png" /></a>
        </div>
    </div>
</div>
<div style="margin-top: 30px"></div>
<div class="row start">
    <div class="col-xs-4"><a href="/music/index"><h3>Musik</h3></a></div>
    <div class="col-xs-7 musicList">
        <g:if test="${musicList.isEmpty()}">
            <h3>Keine Musikinhalte vorhanden</h3>
        </g:if>
        <ul>
            <g:each in="${musicList}" var="release">
                <li>
                    <a data-toggle="modal" href="/release/show?mbid=${release.MBID}" data-target="#modal-music">
                        <g:if test="${release?.AlbumArt}">
                            <img src="${release?.AlbumArt}" alt="${artist?.Name}" />
                        </g:if>
                        <g:else>
                            <asset:image src="symbole/Release.png" alt="No cover available"/>
                        </g:else>
                        <h3>${release.Release} (${release.Year})</h3>
                    </a>
                    <g:link data-toggle="modal" data-target="#modal-music" controller="artist" action="show" params="[artist: release.Artist]">
                        <h5>${release.Artist}</h5>
                    </g:link>
                </li>
            </g:each>
        </ul>
    </div>
    <div class="col-xs-1">
        <div style="width: 100px">
            <a data-toggle="modal" href="/music/create" data-target="#modal-music"><asset:image src="symbole/kreuz.png" /></a>
            <a data-toggle="modal" href="/library/upload?type=music" data-target="#modal-music"><asset:image src="symbole/upload.png" /></a>
        </div>
    </div>
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
</body>
</html>
