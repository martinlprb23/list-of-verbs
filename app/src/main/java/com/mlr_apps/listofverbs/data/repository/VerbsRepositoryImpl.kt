package com.mlr_apps.listofverbs.data.repository;

import com.google.firebase.firestore.CollectionReference
import com.mlr_apps.listofverbs.domain.model.Response.Failure
import com.mlr_apps.listofverbs.domain.model.Response.Success
import com.mlr_apps.listofverbs.domain.model.Verb
import com.mlr_apps.listofverbs.domain.repository.AddVerbResponse
import com.mlr_apps.listofverbs.domain.repository.DeleteVerbResponse
import com.mlr_apps.listofverbs.domain.repository.VerbsRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VerbsRepositoryImpl @Inject constructor(
    private val verbsRef: CollectionReference
): VerbsRepository {
    override fun getVerbsFromFirestore() = callbackFlow {
        val snapshotListener = verbsRef.orderBy("verb").addSnapshotListener { snapshot, e ->
            val verbsResponse = if (snapshot != null) {
                val verbs = snapshot.toObjects(Verb::class.java)
                Success(verbs)
            } else {
                Failure(e)
            }
            trySend(verbsResponse)
        }
         awaitClose{
            snapshotListener.remove()
        }
    }

    override suspend fun addVerbToFirestore(title: String): AddVerbResponse {
        TODO("Not yet implemented")
    }

    override suspend fun deleteVerbFromFirestore(verbId: String): DeleteVerbResponse {
        TODO("Not yet implemented")
    }


}
