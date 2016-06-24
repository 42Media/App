<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="42Media"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:javascript src="jquery-2.2.0.min.js"/>

    <asset:javascript src="bootstrap.js"/>
    <asset:stylesheet src="bootstrap.css"/>

    <asset:javascript src="ftmedia/main.js"/>
    <asset:stylesheet src="ftmedia/main.css"/>



    <g:layoutHead/>
</head>
<body>
    <header>
        <sec:ifLoggedIn>
            <div class="navbar navbar-default navbar-static-top" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <div style="margin: 0 20px 0 20px">
                            <a href="/#">
                                <h2>42Media</h2>
                            </a>
                        </div>
                    </div>
                    <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                        <ul class="nav nav-tabs" >
                            <div class="row">
                                <div class="col-xs-1"><li role="presentation"><h2><label for="suchText"><asset:image src="symbole/lupe.png" /></label></h2></li></div>
                                <div class="col-xs-2"><li role="presentation"><h2><input type="text" class="form-control" id="suchText" /></h2></li></div>
                                <div class="col-xs-2"><li role="presentation"><a href="/video/index"><h2>Filme</h2></a></li></div>
                                <div class="col-xs-2"><li role="presentation"><a href="/music/index"><h2>Musik</h2></a></li></div>
                                <div class="col-xs-1"><li role="presentation">
                                    <h2>
                                        <asset:image src="symbole/left.png" width="22%"/>
                                        <asset:image src="symbole/play.png" width="30%"/>
                                        <asset:image src="symbole/right.png" width="22%"/>
                                    </h2>
                                </li></div>
                                <div class="col-xs-2">
                                    <div class="navbar-right">
                                    <li role="presentation" class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><h2>Profil<span class="caret"></span></h2></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Willkommen ${user}</a></li>
                                        <br>
                                        <li><a href="/library/scan?type=music">Medien verwalten</a></li>
                                        <li><a href="#">Nutzer verwalten</a></li>
                                        <li><a href="#">Merkliste</a></li>
                                        <li><a href="#">Einstellungen</a></li>
                                        <li><a href="/logout">Abmelden</a></li>
                                    </ul></li></div></div>
                            </div>
                        </ul>
                    </div>
                </div>
            </div>
        </sec:ifLoggedIn>
    </header>

    <main>
        <g:if test="${flash.error}">
            <div class="alert alert-error" style="display: block">${flash.error}</div>
        </g:if>
        <g:if test="${flash.message}">
            <div class="alert alert-info" style="display: block">${flash.message}</div>
        </g:if>

        <div class="container-fluid">
            <g:layoutBody/>
        </div>
    </main>
    <footer>
        <div class="footer" role="contentinfo"></div>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>

        <asset:javascript src="application.js"/>

    </footer>

<!-- Modal -->
<div class="modal fade" id="modal-video" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        </div>
    </div>
</div>

<div class="modal fade" id="modal-music" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        </div>
    </div>
</div>

<div class="modal fade" id="modal-edit" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
        </div>
    </div>
</div>

</body>
</html>
