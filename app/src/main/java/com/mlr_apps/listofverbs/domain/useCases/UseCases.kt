package com.mlr_apps.listofverbs.domain.useCases

data class UseCases(
    val getVerbs: GetVerbs,
    val addVerb: AddVerb,
    val deleteVerb: DeleteVerb
)
