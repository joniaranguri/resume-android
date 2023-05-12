package com.joniaranguri.resumeapp.ui.theme

import androidx.compose.ui.graphics.Color

val md_theme_light_primary = Color(0xFF006D3A)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFF5DFF9E)
val md_theme_light_onPrimaryContainer = Color(0xFF00210D)
val md_theme_light_secondary = Color(0xFF006687)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFC1E8FF)
val md_theme_light_onSecondaryContainer = Color(0xFF001E2B)
val md_theme_light_tertiary = Color(0xFF0661A4)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFD2E4FF)
val md_theme_light_onTertiaryContainer = Color(0xFF001D36)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFFDFBFF)
val md_theme_light_onBackground = Color(0xFF001B3D)
val md_theme_light_surface = Color(0xFFFDFBFF)
val md_theme_light_onSurface = Color(0xFF001B3D)
val md_theme_light_surfaceVariant = Color(0xFFDDE5DB)
val md_theme_light_onSurfaceVariant = Color(0xFF414941)
val md_theme_light_outline = Color(0xFF717971)
val md_theme_light_inverseOnSurface = Color(0xFFECF0FF)
val md_theme_light_inverseSurface = Color(0xFF003062)
val md_theme_light_inversePrimary = Color(0xFF33E283)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF006D3A)
val md_theme_light_outlineVariant = Color(0xFFC1C9BF)
val md_theme_light_scrim = Color(0xFF000000)

val md_theme_dark_primary = Color(0xFF33E283)
val md_theme_dark_onPrimary = Color(0xFF00391B)
val md_theme_dark_primaryContainer = Color(0xFF00522A)
val md_theme_dark_onPrimaryContainer = Color(0xFF5DFF9E)
val md_theme_dark_secondary = Color(0xFF72D2FF)
val md_theme_dark_onSecondary = Color(0xFF003548)
val md_theme_dark_secondaryContainer = Color(0xFF004D66)
val md_theme_dark_onSecondaryContainer = md_theme_dark_primary
val md_theme_dark_tertiary = Color(0xFF9FCAFF)
val md_theme_dark_onTertiary = Color(0xFF003259)
val md_theme_dark_tertiaryContainer = Color(0xFF00497E)
val md_theme_dark_onTertiaryContainer = Color(0xFFD2E4FF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF032330)
val md_theme_dark_onBackground = Color(0xFFD6E3FF)
val md_theme_dark_surface = Color(0xFF012553)
val md_theme_dark_onSurface = md_theme_dark_primary
val md_theme_dark_surfaceVariant = Color(0xFF414941)
val md_theme_dark_onSurfaceVariant = Color(0xFFC1C9BF)
val md_theme_dark_outline = Color(0xFF8B938A)
val md_theme_dark_inverseOnSurface = Color(0xFF001B3D)
val md_theme_dark_inverseSurface = Color(0xFFD6E3FF)
val md_theme_dark_inversePrimary = Color(0xFF006D3A)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFF33E283)
val md_theme_dark_outlineVariant = Color(0xFF414941)
val md_theme_dark_scrim = Color(0xFF000000)

// Custom colors
val accentColor = Color(0xFF4794F8)
val shimmerTextColor = Color(0x97C8DEFA)

val violetCard = Color(0xFF450650)
val redCard = Color(0xFFAA011F)
val greenCard = Color(0xFF095F57)
val yellowCard = Color(0xFF8F8424)
val blueCard = Color(0xFF001170)
val orangeCard = Color(0xFFB37E31)
val violetLight = Color(0xFFE9E3FF)
val redLight = Color(0xFFFFE9ED)
val greenLight = Color(0xFFb4e7cc)
val waterBlueLight = Color(0xFFd7faf7)
val blueLight = Color(0xFFc1d9f7)
val yellowLight = Color(0xFFFCF4AF)
val orangeLight = Color(0xFFF5C47B)
val contactColor = Color(0xFF03314B)
fun getColor(colorString: String): Color {
    return when (colorString) {
        "violetCard" -> violetCard
        "redCard" -> redCard
        "greenCard" -> greenCard
        "yellowCard" -> yellowCard
        "blueCard" -> blueCard
        "orangeCard" -> orangeCard
        "violetLight" -> violetLight
        "redLight" -> redLight
        "greenLight" -> greenLight
        "waterBlueLight" -> waterBlueLight
        "blueLight" -> blueLight
        "yellowLight" -> yellowLight
        "orangeLight" -> orangeLight
        else -> md_theme_dark_onBackground
    }
}
