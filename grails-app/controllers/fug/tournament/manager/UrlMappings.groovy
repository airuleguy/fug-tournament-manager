package fug.tournament.manager

class UrlMappings {

    static mappings = {
        group "/gymnastics", {
            "/tournaments"(controller: "tournament")
            "/tournaments/$id"(controller: "tournament", action: "show")
            "/tournaments/$id/edit"(controller: "tournament", action: "edit")
            "/tournaments/create"(controller: "tournament", action: "create")
            "/tournaments/save"(controller: "tournament", action: "save")
            "/tournaments/update"(controller: "tournament", action: "update")
            "/tournaments/$id/delete"(controller: "tournament", action: "delete")

            "/tournaments/$tournamentId/scores"(controller: "score")
            "/tournaments/$tournamentId/scores/$id"(controller: "score", action: "show")
            "/tournaments/$tournamentId/scores/$id/edit"(controller: "score", action: "edit")
            "/tournaments/$tournamentId/scores/$id/delete"(controller: "score", action: "delete")
            "/tournaments/$tournamentId/scores/create"(controller: "score", action: "create")
            "/tournaments/$tournamentId/scores/save"(controller: "score", action: "save")
            "/tournaments/$tournamentId/scores/$id/update"(controller: "score", action: "update")

            "/categories"(controller: "category")
            "/categories/$id"(controller: "category", action: "show")
            "/categories/$id/edit"(controller: "category", action: "edit")
            "/categories/$id/udpdate"(controller: "category", action: "udpdate")
            "/categories/$id/delete"(controller: "category", action: "delete")
            "/categories/create"(controller: "category", action: "create")
            "/categories/save"(controller: "category", action: "save")

            "/clubs"(controller: "club")
            "/clubs/$id"(controller: "club", action: "show")
            "/clubs/$id/edit"(controller: "club", action: "edit")
            "/clubs/$id/update"(controller: "club", action: "update")
            "/clubs/$id/delete"(controller: "club", action: "delete")
            "/clubs/create"(controller: "club", action: "create")
            "/clubs/save"(controller: "club", action: "save")

            "/exercises"(controller: "exercise")
            "/exercises/$id"(controller: "exercise", action: "show")
            "/exercises/$id/edit"(controller: "exercise", action: "edit")
            "/exercises/$id/update"(controller: "exercise", action: "update")
            "/exercises/$id/delete"(controller: "exercise", action: "delete")
            "/exercises/create"(controller: "exercise", action: "create")
            "/exercises/save"(controller: "exercise", action: "save")

            "/level"(controller: "level")
            "/level/$id"(controller: "level", action: "show")
            "/level/$id/edit"(controller: "level", action: "edit")
            "/level/$id/update"(controller: "level", action: "update")
            "/level/$id/delete"(controller: "level", action: "delete")
            "/level/create"(controller: "level", action: "create")
            "/level/save"(controller: "level", action: "save")

            "/gymnast"(controller: "gymnast")
            "/gymnast/$id"(controller: "gymnast", action: "show")
            "/gymnast/$id/edit"(controller: "gymnast", action: "edit")
            "/gymnast/$id/update"(controller: "gymnast", action: "update")
            "/gymnast/$id/delete"(controller: "gymnast", action: "delete")
            "/gymnast/create"(controller: "gymnast", action: "create")
            "/gymnast/save"(controller: "gymnast", action: "save")

            "/winCondition/$tournamentId/allaround"(controller: "winCondition", action: "allAround")
            "/winCondition/$tournamentId/clubs"(controller: "winCondition", action: "clubs")
            "/winCondition/$tournamentId/exercises"(controller: "winCondition", action: "exercises")
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
