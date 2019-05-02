<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="system.title" default="Tournament Manager | FUG" /></title>
</head>
<body>
    <div id="content" role="main">
        <section class="row">
            <h1><g:message code="system.title" default="Tournament Manager | FUG" /> </h1>
        </section>
        <section class="row">
            <div id="controllers" role="navigation">
                <h2><g:message code="default.home.goto" default="Manage" /></h2>
                <ul>
                    <li class="controller">
                        <g:link controller="Tournament"><g:message code="tournament.label" /></g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="GymnastController"><g:message code="gymnast.label" /></g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="LevelController"><g:message code="level.label" /></g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="CategoryController"><g:message code="category.label" /></g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="ClubController"><g:message code="club.label" /></g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="ExerciseController"><g:message code="exercise.label" /></g:link>
                    </li>
                </ul>
            </div>
        </section>
    </div>

</body>
</html>
