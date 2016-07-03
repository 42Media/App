<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
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
                <div class="releaseList assetList">
                    <h4>Alben</h4>
                    <ul>
                    <g:each in="${releases}" var="release">
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