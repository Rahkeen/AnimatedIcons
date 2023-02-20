package co.rikin.animatedicons.examples

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import app.rive.runtime.kotlin.RiveAnimationView
import app.rive.runtime.kotlin.RiveTextureView
import co.rikin.animatedicons.R
import co.rikin.animatedicons.ui.theme.AnimatedIconsTheme
import co.rikin.animatedicons.ui.theme.Coffeeshop
import co.rikin.animatedicons.ui.theme.TerraCotta
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Preview
@Composable
fun RiveTrashButton() {
  var clicked by remember {
    mutableStateOf(false)
  }
  val scope = rememberCoroutineScope()

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
          clicked = true
          delay(50)
          clicked = false
        }
      },
    contentAlignment = Alignment.Center
  ) {
    AndroidView(
      modifier = Modifier.size(24.dp),
      factory = {
        RiveAnimationView(it).apply {
          setRiveResource(R.raw.trash_can)
        }
      }, update = { view ->
        view.setBooleanState("Main State Machine", "click", clicked)
      })
  }
}

@Preview
@Composable
fun CoffeeLoaderExample() {
  val progress = remember {
    Animatable(0f)
  }
  val scope = rememberCoroutineScope()
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(
        color = Coffeeshop,
      )
      .pointerInput(Unit) {
        detectDragGestures { change, dragAmount ->
          val y = dragAmount.y
          val current = progress.value
          val new = (current - y).coerceIn(0f, 100f)
          scope.launch {
            progress.animateTo(new)
          }
        }
      },
    contentAlignment = Alignment.Center,

  ) {
    AndroidView(
      modifier = Modifier.size(100.dp),
      factory = { context ->
        RiveAnimationView(context).apply {
          setRiveResource(R.raw.cup_loader)
          setNumberState("State Machine 1", "numLoader", 0f)
        }
      }, update = { view ->
        view.setNumberState("State Machine 1", "numLoader", progress.value)
      })
  }
}