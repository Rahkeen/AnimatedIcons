package co.rikin.animatedicons.examples

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.rikin.animatedicons.ui.theme.TerraCotta
import kotlinx.coroutines.launch

@Preview
@Composable
fun IconButton() {
  val icon = Icons.Rounded.Delete
  val scope = rememberCoroutineScope()
  val rotation = remember { Animatable(0f) }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = TerraCotta,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          rotation.animateTo(0f, keyframes {
            durationMillis = 750
            10f at 150
            -10f at 300
            5f at 450
            -5f at 600
          })
        }
      },
    contentAlignment = Alignment.Center
  ) {
    Image(
      modifier = Modifier
        .size(24.dp)
        .graphicsLayer { rotationZ = rotation.value },
      imageVector = icon,
      contentDescription = "Trash",
      colorFilter = ColorFilter.tint(Color.White)
    )
  }
}