package com.mlr_apps.listofverbs.screens.verbs

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mlr_apps.listofverbs.screens.verbs.components.Verbs
import com.mlr_apps.listofverbs.screens.verbs.components.VerbsContent
import com.mlr_apps.listofverbs.ui.theme.AgeoFont
import com.mlr_apps.listofverbs.ui.theme.ListOfVerbsTheme

@Composable
fun VerbsScreen(viewModel: VerbsViewModel = hiltViewModel()) {
    ListOfVerbsTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(title = {
                        Text(
                            text = "List of Verbs",
                            fontFamily = AgeoFont,
                            fontWeight = FontWeight.Bold
                        )
                    }, elevation = 6.dp)
                },
                content = {
                    Column(modifier = Modifier.padding(it)) {
                        Verbs(
                            verbsContent = { verbs ->
                                VerbsContent(
                                    verbs = verbs
                                )
                            }
                        )
                    }
                }
            )

        }
    }

}