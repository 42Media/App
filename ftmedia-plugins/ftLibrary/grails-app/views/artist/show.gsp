<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div id="show-Artist" class="content scaffold-show" role="main">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">${artist?.Name}</div>
        <div class="ArtistPicture">
            <g:if test="${artist?.Bild}">
                <img src="${artist.Bild}" alt="${artist?.Name}" />
            </g:if>
            <g:else>
                <asset:image src="symbole/Artist.png" alt="No image available"/>
            </g:else>
        </div>
        <div class="panel-body">
            <div class="releaseList assetList">
                <h4>Veröffentlichungen:</h4>
                <ul>
                    <g:each in="${releases}" var="release">
                        <li>
                            <a data-toggle="modal" href="/release/show?mbid=${release.MBID}" data-target="#modal-music" >

                                <g:if test="${release?.AlbumArt}">
                                    <img src="${release?.AlbumArt}" alt="${artist?.Name}" />
                                </g:if>
                                <g:else>
                                    <asset:image src="symbole/Release.png" alt="No cover available"/>
                                </g:else>
                                <h3>${release.Artist} - ${release.Release} (${release.Year})</h3>
                            </a>
                        </li>
                    </g:each>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>