<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'score.label', default: 'Score')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-score" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" uri="/tournaments/${tournament.id}/scores/create" ><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="list-score" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <h2><g:message code="score.tournament.label"/>: <g:link controller="tournament" action="show" id="${tournament.id}">${tournament}</g:link></h2>
            <f:table collection="${scoreList}" />

            <div class="pagination">
                <g:paginate controller="score" action="index" params="[tournamentId: tournament.id]" total="${scoreCount ?: 0}" />
            </div>
        </div>
    </body>
</html>