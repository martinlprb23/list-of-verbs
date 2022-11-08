package com.mlr_apps.listofverbs.screens.verbs.components

import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.mlr_apps.listofverbs.domain.model.Response
import com.mlr_apps.listofverbs.domain.repository.Verbs
import com.mlr_apps.listofverbs.screens.verbs.VerbsViewModel

@Composable
fun Verbs(
    viewModel: VerbsViewModel = hiltViewModel(),
    verbsContent: @Composable (verbs: Verbs)-> Unit
) {
    when(val verbsResponse = viewModel.verbsResponse){
        is Response.Loading -> CircularProgressIndicator()
        is Response.Success -> verbsContent(verbsResponse.data)
        is Response.Failure -> print(verbsResponse.e)
    }
}