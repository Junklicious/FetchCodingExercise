package com.lanekersten.fetchcodingexercise.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lanekersten.fetchcodingexercise.viewModel.ListItemViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListItemView(modifier: Modifier, viewModel: ListItemViewModel) {

    val listItemData = viewModel.listItemData.observeAsState().value
    val isLoading = viewModel.isLoading.observeAsState().value

    Box(contentAlignment = Alignment.Center) {
        if (isLoading == true) {
            CircularProgressIndicator()
        }

        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (listItemData == null) { return@LazyColumn }

            listItemData.forEach { (listId, listItems) ->
                stickyHeader {
                    ListIdHeader(modifier = Modifier.fillMaxWidth(), listId = listId)
                }
                items(listItems) { listItem ->
                    if (listItem.name == null) { return@items }
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                        text = listItem.name
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ListIdHeader(modifier: Modifier, listId: Int) {
    Box(modifier = modifier.background(MaterialTheme.colorScheme.secondary)) {
        Text(modifier = Modifier.padding(all = 8.dp),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSecondary,
            text = "List ID: $listId")
    }
}