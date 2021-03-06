<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tournament.label', default: 'Tournament')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-tournament" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-tournament" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="tournament" except="scores"/>
            <g:form resource="${this.tournament}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="list" controller="score" action="index" params="[tournamentId: this.tournament.id]"><g:message code="tournament.scores.label" default="Scores" /></g:link>
                    <g:link class="edit" action="edit" resource="${this.tournament}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    <g:link class="list" controller="winCondition" action="allAround" params="[tournamentId: this.tournament.id]"><g:message code="winCondition.allAround.label" default="Winners" /></g:link>
                    <g:link class="list" controller="winCondition" action="clubs" params="[tournamentId: this.tournament.id]"><g:message code="winCondition.clubs.label" default="Winners" /></g:link>
                    <g:link class="list" controller="winCondition" action="exercises" params="[tournamentId: this.tournament.id]"><g:message code="winCondition.exercises.label" default="Winners" /></g:link>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
