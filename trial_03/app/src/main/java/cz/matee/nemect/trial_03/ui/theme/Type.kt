package cz.matee.nemect.trial_03.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    // Sections
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),

    // names of albs
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    ),
    // button description
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.5.sp
    )
)

// ENORMOUS TEXT DISPLAYED
// displayLarge
// displayMedium
// displaySmall

// SCREENS
// headlineLarge
// headlineMedium
// headlineSmall

// PARAGRAPH'S TITLE
// titleLarge
// titleMedium
// titleSmall

// PARAGRAPH
// bodyLarge
// bodyMedium
// bodySmall

// BUTTONS
// labelLarge
// labelMedium
// labelSmall