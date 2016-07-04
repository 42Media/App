<!DOCTYPE html>
<html>
<head>
</head>
<body>
<div class="content scaffold-show showRelease" role="main">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">${release?.tracks?.first().albumArtist} - ${release?.tracks?.first().release}</div>
        <div class="panel-body">
            <div class="release">
                <div class="releasePicture">
                    <g:if test="${release?.metaData?.AlbumArt}">
                        <img src="${release?.metaData?.AlbumArt}" alt="${release?.metaData?.Albumkünstler}" />
                    </g:if>
                    <g:else>
                        <asset:image src="symbole/Release.png" alt="No image available"/>
                    </g:else>
                </div>
                <div class="tracks">
                <h4>${release?.tracks.first().release}</h4>
                    <ul>
                        <g:each in="${release.tracks}" var="track">
                            <li>
                                ${track.displayNr}&nbsp;-&nbsp;${track.title}
                            </li>
                        </g:each>
                    </ul>
                </div>
            </div>
        </div>
        <div class="panel-heading">LastFM</div>
        <div class=""panel-body>
            <g:each in="${release?.metaData}" var="data">
                ${data.key}: ${data.value}</br>
            </g:each>
        </div>
    </div>
</div>
</body>
</html>