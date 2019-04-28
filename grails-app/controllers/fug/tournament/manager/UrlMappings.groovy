package fug.tournament.manager

class UrlMappings {

    static mappings = {
        group "/gymnastics", {
            "/tournaments"(controller: "tournament")
            "/tournaments/$id"(controller: "tournament", action: "show")
            "/tournaments/$id/edit"(controller: "tournament", action: "edit")
            "/tournaments/create"(controller: "tournament", action: "create")
            "/tournaments/$id/delete"(controller: "tournament", action: "delete")

            "/tournaments/$tournamentId/scores"(controller: "score")
            "/tournaments/$tournamentId/scores/$id"(controller: "score", action: "show")
            "/tournaments/$tournamentId/scores/$id/edit"(controller: "score", action: "edit")
            "/tournaments/$tournamentId/scores/$id/delete"(controller: "score", action: "delete")
            "/tournaments/$tournamentId/scores/create"(controller: "score", action: "create")

            "/categories"(controller: "category")
            "/categories/$id"(controller: "category", action: "show")
            "/categories/$id/edit"(controller: "category", action: "edit")
            "/categories/$id/delete"(controller: "category", action: "delete")
            "/categories/create"(controller: "category", action: "create")

            "/clubs"(controller: "club")
            "/clubs/$id"(controller: "club", action: "show")
            "/clubs/$id/edit"(controller: "club", action: "edit")
            "/clubs/$id/delete"(controller: "club", action: "delete")
            "/clubs/create"(controller: "club", action: "create")

            "/exercises"(controller: "exercise")
            "/exercises/$id"(controller: "exercise", action: "show")
            "/exercises/$id/edit"(controller: "exercise", action: "edit")
            "/exercises/$id/delete"(controller: "exercise", action: "delete")
            "/exercises/create"(controller: "exercise", action: "create")

            "/level"(controller: "level")
            "/level/$id"(controller: "level", action: "show")
            "/level/$id/edit"(controller: "level", action: "edit")
            "/level/$id/delete"(controller: "level", action: "delete")
            "/level/create"(controller: "level", action: "create")

            "/gymnast"(controller: "gymnast")
            "/gymnast/$id"(controller: "gymnast", action: "show")
            "/gymnast/$id/edit"(controller: "gymnast", action: "edit")
            "/gymnast/$id/delete"(controller: "gymnast", action: "delete")
            "/gymnast/create"(controller: "gymnast", action: "create")

            "/winCondition/$tournamentId/allaround"(controller: "winCondition", action: "allAround")
            "/winCondition/$tournamentId/clubs"(controller: "winCondition", action: "clubs")
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
