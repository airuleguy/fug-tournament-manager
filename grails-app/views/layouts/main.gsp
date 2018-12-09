<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="container">
        <div class="navbar navbar-expand-lg navbar-dark bg-dark" role="navigation">
            <a class="navbar-brand" href="/#">
                <g:message code="default.home.title" default="Uruguayan Federation of Gymnastics" />
            </a>
        </div>

        <g:layoutBody/>

        <div class="footer" role="contentinfo"></div>

        <div id="spinner" class="spinner" style="display:none;">
            <g:message code="spinner.alt" default="Loading&hellip;"/>
        </div>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
