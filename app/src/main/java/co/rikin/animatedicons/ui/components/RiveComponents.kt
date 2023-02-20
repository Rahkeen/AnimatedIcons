package co.rikin.animatedicons.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import app.rive.runtime.kotlin.RiveAnimationView
import co.rikin.animatedicons.R
import co.rikin.animatedicons.ui.theme.TerraCotta
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RiveTrashButton() {
  val scope = rememberCoroutineScope()
  var clicked by remember { mutableStateOf(false) }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(color = TerraCotta, shape = RoundedCornerShape(16.dp))
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          clicked = true
          delay(100)
          clicked = false
        }
      },
    contentAlignment = Alignment.Center
  ) {
    AndroidView(
      modifier = Modifier.size(24.dp),
      factory = { context ->
        RiveAnimationView(context).apply {
          setRiveResource(
            resId = R.raw.trash_can,
            stateMachineName = "Main State Machine",
          )
        }
      },
      update = { view ->
        view.setBooleanState(
          stateMachineName = "Main State Machine",
          inputName = "click",
          clicked
        )
      }
    )
  }
}
