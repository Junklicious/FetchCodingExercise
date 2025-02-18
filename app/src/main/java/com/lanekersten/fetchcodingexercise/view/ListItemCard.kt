package com.lanekersten.fetchcodingexercise.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lanekersten.fetchcodingexercise.model.ListItem

@Composable
fun ListItemCard(modifier: Modifier, listItem: ListItem) {
    ElevatedCard(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)) {
        if (listItem.name == null) { return@ElevatedCard }
        Row(
            modifier = Modifier.fillMaxWidth().padding(all = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = listItem.name,
                modifier = Modifier.padding(all = 4.dp)
            )
            Column {
                Text(
                    text = "List ID: ${listItem.listId}",
                    modifier = Modifier.padding(all = 4.dp)
                )
                Text(
                    text = "ID: ${listItem.id}",
                    modifier = Modifier.padding(all = 4.dp)
                )
            }
        }
    }
}