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
            </ul>
        </div>

        <div>
            <g:select name="level" from="levels"></g:select>
        </div>
        <div id="winner-by-categ-and-level" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="table-responsive-sm">
            <table class="table table-striped table-hover">
                <thead class="thead-light">
                    <tr>
                        <th>#</th>
                        <th>${message(code: 'gymnast.label', default: 'Gymnast')}</th>
                        <th>${message(code: 'score.label', default: 'Score')}</th>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${winners}" var="winner" status="ix" >
                        <tr>
                            <td>${ix+1}</td>
                            <td>${winner.gymnast}</td>
                            <td>${winner.total_score}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
            </div>

            <f:table collection="${winners}" properties="${["gymnast", "total_score"]}"/>
            <div class="pagination">
                <g:paginate total="${count ?: 0}" />
            </div>
        </div>
    </body>
</html>