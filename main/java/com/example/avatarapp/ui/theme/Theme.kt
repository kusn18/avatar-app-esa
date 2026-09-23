package com.example.avatarapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = LightBlue,
    secondary = LightBlue,
    tertiary = LightBlue,
    background = NavyBlue,
    surface = NavyBlue,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = White,
    onSurface = White
)

private val DarkColorScheme = darkColorScheme(
    primary = LightBlue,
    secondary = LightBlue,
    tertiary = LightBlue,
    background = NavyBlue,
    surface = NavyBlue,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = White,
    onSurface = White
)

@Composable
fun AvatarAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}