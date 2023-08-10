package cz.matee.nemect.trial_02.presentation.ui.theme

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    // 60 100 20 90 ??
    primary = White100,
//    onPrimary = Purple100,
//    primaryContainer = Purple20,
//    onPrimaryContainer = Purple90,
    inversePrimary = White0,

    //
    secondary = White40,
    onSecondary = White100,
//    secondaryContainer = Blue20,
//    onSecondaryContainer = Blue90,

    //
    tertiary = Green30,
    onTertiary = Green0,
//    tertiaryContainer = White20,
//    onTertiaryContainer = White90,

    //
    background = White5,
    onBackground = White100,

    //
    surface = White5,
    onSurface = White100,
//    surfaceVariant = Purple20,
//    onSurfaceVariant = Purple100,
    surfaceTint = White0,
//    inverseSurface = Purple20,
//    inverseOnSurface = Purple100,

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
    primary = White0,
    onPrimary = White100,
//    primaryContainer = Blue90,
//    onPrimaryContainer = Blue10,
//    inversePrimary = ,

    secondary = White30,
    onSecondary = White90,
//    secondaryContainer = Purple90,
//    onSecondaryContainer = Purple10,

    tertiary = Green40,
    onTertiary = Green100,
//    tertiaryContainer = White90,
//    onTertiaryContainer = White10,

    //
    background = White100,
    onBackground = White0,

    // 100 0 90 0
    surface = Green20,
    onSurface = Green100,
//    surfaceVariant = Blue90,
//    onSurfaceVariant = Blue0,
    surfaceTint = White0,
//    inverseSurface = Blue80,
//    inverseOnSurface = Blue0,

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
fun Trial_02Theme(
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
            val activity  = view.context as Activity
            activity.window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme

//            val window = (view.context as Activity).window
//            window.statusBarColor = if (darkTheme)  Color.Black.toArgb() else Color.White.toArgb()
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}