<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="42Media"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="bootstrap.css"/>

    <g:layoutHead/>
</head>
<body class="container" >
<ul class="nav nav-tabs" >
    <div class="row">
        <div class="col-xs-1"><li role="presentation"><h2><label for="suchText"><asset:image src="symbole/lupe.png" /></label></h2></li></div>
        <div class="col-xs-2"><li role="presentation"><h2><input type="text" class="form-control" id="suchText" /></h2></li></div>
        <div class="col-xs-2"><li role="presentation"><a href="#"><h2>Filme</h2></a></li></div>
        <div class="col-xs-2"><li role="presentation"><a href="#"><h2>42Media</h2></a></li></div>
        <div class="col-xs-2"><li role="presentation"><a href="#"><h2>Musik</h2></a></li></div>
        <div class="col-xs-1"><li role="presentation">
            <h2>
                <asset:image src="symbole/left.png" width="22%"/>
                <asset:image src="symbole/play.png" width="30%"/>
                <asset:image src="symbole/right.png" width="22%"/>
            </h2>
        </li></div>
        <div class="col-xs-2"><li role="presentation" class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><h2>Profil<span class="caret"></span></h2></a>
            <ul class="dropdown-menu">
                <li><a href="#">Medien verwalten</a></li>
                <li><a href="#">Nutzer verwalten</a></li>
                <li><a href="#">Merkliste</a></li>
                <li><a href="#">Einstellungen</a></li>
                <li><a href="#">Abmelden</a></li>
            </ul></li></div>
    </div>
</ul>
    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>

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
<div class="row">
    <div class="col-xs-4"><a href="#"><h3>Filme</h3></a></div>
    <div class="col-xs-7"><h3>Scrollbare Filmleiste</h3></div>
    <div class="col-xs-1"><h3><asset:image src="symbole/kreuz.png" /></h3></div>
</div>
<div class="row">
    <div class="col-xs-4"><a href="#"><h3>Musik</h3></a></div>
    <div class="col-xs-7"><h3>Scrollbare Musikleiste</h3></div>
    <div class="col-xs-1"><h3><asset:image src="symbole/kreuz.png" /></h3></div>
</div>
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

