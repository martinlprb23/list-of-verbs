package com.mlr_apps.listofverbs.screens.verbs

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlr_apps.listofverbs.domain.model.Response
import com.mlr_apps.listofverbs.domain.useCases.UseCases
import com.mlr_apps.listofverbs.domain.repository.VerbsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerbsViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    var verbsResponse by mutableStateOf<VerbsResponse>(Response.Loading)
    private set

    init {
        getVerbs()
    }

    private fun getVerbs() = viewModelScope.launch {
        useCases.getVerbs().collect{response ->
            verbsResponse = response
            Log.i("Verbs", response.toString())
        }
    }

}
