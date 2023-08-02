package cz.matee.nemect.trial_01.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    // 60 100 20 90 ??
    primary = Purple60,
    onPrimary = Purple100,
    primaryContainer = Purple20,
    onPrimaryContainer = Purple90,
//    inversePrimary = ,

    //
    secondary = Blue60,
    onSecondary = Blue100,
    secondaryContainer = Blue20,
    onSecondaryContainer = Blue90,

    //
    tertiary = White60,
    onTertiary = White100,
    tertiaryContainer = White20,
    onTertiaryContainer = White90,

    //
    background = White20,
    onBackground = White100,

    //
    surface = Purple10,
    onSurface = Purple100,
    surfaceVariant = Purple20,
    onSurfaceVariant = Purple100,
    surfaceTint = Purple80,
    inverseSurface = Purple20,
    inverseOnSurface = Purple100,

    //
//    error = ,
//    onError = ,
//    errorContainer = ,
//    onErrorContainer = ,

    //
    outline = White50,
    outlineVariant = White20,

    //
//    scrim = ,
)

private val LightColorScheme = lightColorScheme(
    // 40 100 90 10 ??
    primary = Blue40,
    onPrimary = Blue100,
    primaryContainer = Blue90,
    onPrimaryContainer = Blue10,
//    inversePrimary = ,

    secondary = Purple40,
    onSecondary = Purple100,
    secondaryContainer = Purple90,
    onSecondaryContainer = Purple10,

    tertiary = White40,
    onTertiary = White100,
    tertiaryContainer = White90,
    onTertiaryContainer = White10,

    //
    background = White100,
    onBackground = White0,

    // 100 0 90 0
    surface = Blue100,
    onSurface = Blue0,
    surfaceVariant = Blue90,
    onSurfaceVariant = Blue0,
    surfaceTint = Blue20,
    inverseSurface = Blue80,
    inverseOnSurface = Blue0,

    //
//    error = ,
//    onError = ,
//    errorContainer = ,
//    onErrorContainer = ,

    //
    outline = White50,
    outlineVariant = White80,

    //
//    scrim = ,
)

@Composable
fun Trial_01Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}