package com.mlr_apps.listofverbs.domain.useCases

import com.mlr_apps.listofverbs.domain.repository.VerbsRepository

class GetVerbs(private val repo: VerbsRepository) {
    operator fun invoke()= repo.getVerbsFromFirestore()
}
