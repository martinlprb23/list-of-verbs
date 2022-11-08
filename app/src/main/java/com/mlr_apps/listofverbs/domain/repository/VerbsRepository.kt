package com.mlr_apps.listofverbs.domain.repository

import com.mlr_apps.listofverbs.domain.model.Response
import com.mlr_apps.listofverbs.domain.model.Verb
import kotlinx.coroutines.flow.Flow


typealias Verbs = List<Verb>
typealias VerbsResponse = Response<Verbs>
typealias AddVerbResponse = Response<Boolean>
typealias DeleteVerbResponse = Response<Boolean>

interface VerbsRepository {
    fun getVerbsFromFirestore(): Flow<VerbsResponse>

    suspend fun addVerbToFirestore(title: String): AddVerbResponse

    suspend fun deleteVerbFromFirestore(verbId: String): DeleteVerbResponse
}