package com.mlr_apps.listofverbs.di


import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mlr_apps.listofverbs.data.repository.VerbsRepositoryImpl
import com.mlr_apps.listofverbs.domain.model.Verb
import com.mlr_apps.listofverbs.domain.useCases.AddVerb
import com.mlr_apps.listofverbs.domain.useCases.DeleteVerb
import com.mlr_apps.listofverbs.domain.useCases.GetVerbs
import com.mlr_apps.listofverbs.domain.useCases.UseCases
import com.mlr_apps.listofverbs.domain.repository.VerbsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Provides
    fun provideFirebaseFirestore() = Firebase.firestore

    @Provides
    fun provideVerbsRef(
        db: FirebaseFirestore
    ) = db.collection("verbs")

    @Provides
    fun provideVerbsRepository(
        verbsRef: CollectionReference
    ): VerbsRepository = VerbsRepositoryImpl(verbsRef)

    @Provides
    fun provideUseCases(
        repo: VerbsRepository
    ) = UseCases(
        getVerbs = GetVerbs(repo),
        addVerb = AddVerb(repo),
        deleteVerb = DeleteVerb(repo)
    )
}