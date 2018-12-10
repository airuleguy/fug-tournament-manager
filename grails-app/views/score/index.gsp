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
                <li><g:link class="create" action="create" uri="/gymnastics/tournaments/${tournament.id}/scores/create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <h1 class="display-4"><small><g:message code="tournament.label" />:</small> ${tournament.name}</h1>
        <div class="card">
            <div class="card-body">
            <h3 class="card-title"><g:message code="default.list.label" args="[entityName]" /></h3>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div id="list-score" class="content scaffold-list" role="main">
                <f:table collection="${scoreList}" properties="${["gymnast", "exercise", "score"]}" />

                <div class="pagination">
                    <g:paginate total="${scoreCount ?: 0}" />
                </div>
            </div>
            </div>
        </div>
    </body>
</html>