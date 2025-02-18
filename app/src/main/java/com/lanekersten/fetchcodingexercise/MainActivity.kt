package com.lanekersten.fetchcodingexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.lanekersten.fetchcodingexercise.ui.theme.AppTheme
import com.lanekersten.fetchcodingexercise.view.ListItemView
import com.lanekersten.fetchcodingexercise.viewModel.ListItemViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val listItemViewModel = ViewModelProvider(this)[ListItemViewModel::class.java]

        setContent {
            AppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Fetch Coding Exercise")
                            }
                        )
                    }
                ) { innerPadding ->
                    ListItemView(modifier = Modifier.padding(innerPadding), viewModel = listItemViewModel)
                }
            }
        }
    }
}