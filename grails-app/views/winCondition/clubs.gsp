<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'winCondition.label', default: 'Winners')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div class="nav" role="navigation">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
            <li><g:link class="list" action="allAround" params="[tournamentId: tournament.id]"><g:message code="winCondition.allAround.label" /></g:link></li>
            <li><g:link class="list" action="exercises" params="[tournamentId: tournament.id]"><g:message code="winCondition.exercises.label" /></g:link></li>
        </ul>
    </div>
    <div class="content scaffold-list" role="main">
        <div class="card-title">
            <h1><g:message code="score.tournament.label"/>: <g:link controller="tournament" action="show" id="${tournament.id}">${tournament}</g:link></h1>
        </div>
        <div class="card-body">
        <g:each in="${ranking}" var="current">
            <h3><g:message code="level.label" />: ${current.level}</h3>

            <div id="list-gymnast" class="content scaffold-list" role="main">
                <f:table collection="${current.rank}" properties="${props}" domainClass="fug.tournament.api.WinCondition" />
            </div>
        </g:each>
        </div>
    </div>
    </body>
</html>