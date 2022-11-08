package com.mlr_apps.listofverbs.domain.useCases

import com.mlr_apps.listofverbs.domain.repository.VerbsRepository

class AddVerb (
    private val repo: VerbsRepository
){
    suspend operator fun invoke(
        name: String
    ) = repo.addVerbToFirestore(name)
}
