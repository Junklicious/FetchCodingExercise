package com.lanekersten.fetchcodingexercise.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = FetchPurple,
    secondary = DarkGrey,
    onSecondary = Color.White,
    surface = FetchPurple,
    onSurface = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = FetchOrange,
    secondary = LightGrey,
    onSecondary = Color.Black,
    surface = FetchOrange,
    onSurface = Color.White
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}