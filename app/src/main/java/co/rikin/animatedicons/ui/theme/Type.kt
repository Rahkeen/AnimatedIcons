package co.rikin.animatedicons.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.rikin.animatedicons.R

// Set of Material typography styles to start with
val plexFamily = FontFamily(
    Font(resId = R.font.plex_regular, weight = FontWeight.Normal)
)
val Typography = Typography(
  defaultFontFamily = plexFamily,
  body1 = TextStyle(
    fontFamily = plexFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  caption = TextStyle(
    fontFamily = plexFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp
  )
  /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)