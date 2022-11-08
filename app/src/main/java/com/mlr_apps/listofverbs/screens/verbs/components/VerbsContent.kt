package com.mlr_apps.listofverbs.screens.verbs.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mlr_apps.listofverbs.domain.model.Verb
import com.mlr_apps.listofverbs.domain.repository.Verbs
import com.mlr_apps.listofverbs.ui.theme.AgeoFont

@Composable
fun VerbsContent(verbs: Verbs) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(verbs) { verb ->
            CardVerb(verb)
        }
    }
}

@Composable
fun CardVerb(verb: Verb) {
    Card(
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            verb.verb?.let {
                Text(
                    text = it,
                    fontFamily = AgeoFont,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
        }

    }
}