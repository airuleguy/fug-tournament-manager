package fug.tournament.manager

class UrlMappings {

    static mappings = {
        group "/gymnastics", {
            "/tournament"(controller: "tournament")
            "/tournament/$id"(controller: "tournament", action: "show")
            "/tournament/$id/edit"(controller: "tournament", action: "edit")
            "/tournament/create"(controller: "tournament", action: "create")
            "/tournament/$id/delete"(controller: "tournament", action: "delete")

            "/tournament/$tournamentId/score"(controller: "score")
            "/tournament/$tournamentId/score/$id"(controller: "score", action: "show")
            "/tournament/$tournamentId/score/$id/edit"(controller: "score", action: "edit")
            "/tournament/$tournamentId/score/$id/delete"(controller: "score", action: "delete")
            "/tournament/$tournamentId/score/create"(controller: "score", action: "create")

            "/category"(controller: "category")
            "/category/$id"(controller: "category", action: "show")
            "/category/$id/edit"(controller: "category", action: "edit")
            "/category/$id/delete"(controller: "category", action: "delete")
            "/category/create"(controller: "category", action: "create")

            "/club"(controller: "club")
            "/club/$id"(controller: "club", action: "show")
            "/club/$id/edit"(controller: "club", action: "edit")
            "/club/$id/delete"(controller: "club", action: "delete")
            "/club/create"(controller: "club", action: "create")

            "/exercise"(controller: "exercise")
            "/exercise/$id"(controller: "exercise", action: "show")
            "/exercise/$id/edit"(controller: "exercise", action: "edit")
            "/exercise/$id/delete"(controller: "exercise", action: "delete")
            "/exercise/create"(controller: "exercise", action: "create")

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
        }


        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
