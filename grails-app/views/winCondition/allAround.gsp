<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'winCondition.label', default: 'Winners')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div class="card">
        <div class="card-title">
            <h1><f:display bean="tournament" property="name"/></h1>
        </div>
        <div class="card-body">
        <g:each in="${ranking}" var="current">
            <h3><g:message code="level.label" />: ${current.level}</h3>
            <h3><g:message code="category.label" />: ${current.category}</h3>

            <div id="list-gymnast" class="content scaffold-list" role="main">
                <f:table collection="${current.rank}" properties="${props}" domainClass="fug.tournament.api.WinCondition" />
                <div class="pagination">
                    <g:paginate total="${current.rank.size() ?: 0}" />
                </div>
            </div>
        </g:each>
        </div>
    </div>
    </body>
</html>