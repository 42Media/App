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
