package co.rikin.animatedicons.examples

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.rikin.animatedicons.ui.theme.TerraCotta

@Preview
@Composable
fun IconButton() {
  val icon = Icons.Rounded.Delete
  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = TerraCotta,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {},
    contentAlignment = Alignment.Center
  ) {
    Image(
      modifier = Modifier.size(24.dp),
      imageVector = icon,
      contentDescription = "Trash",
      colorFilter = ColorFilter.tint(Color.White)
    )
  }
}

@Preview
@Composable
fun ManualIconButton() {
  val icon = Icons.Rounded.Delete
  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = TerraCotta,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {},
    contentAlignment = Alignment.Center
  ) {
    Image(
      modifier = Modifier.size(24.dp),
      imageVector = icon,
      contentDescription = "Trash",
      colorFilter = ColorFilter.tint(Color.White)
    )
  }
}
