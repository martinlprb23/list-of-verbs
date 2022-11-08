package com.mlr_apps.listofverbs.domain.useCases

import com.mlr_apps.listofverbs.domain.repository.VerbsRepository

class DeleteVerb (
    private val repo: VerbsRepository
) {
    suspend operator fun invoke(verbId: String) = repo.deleteVerbFromFirestore(verbId)
}
