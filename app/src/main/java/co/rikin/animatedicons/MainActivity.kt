package co.rikin.animatedicons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import app.rive.runtime.kotlin.RiveAnimationView
import co.rikin.animatedicons.ui.theme.AnimatedIconsTheme
import co.rikin.animatedicons.ui.theme.Eggshell
import co.rikin.animatedicons.ui.theme.GreenSheen
import co.rikin.animatedicons.ui.theme.Independence
import co.rikin.animatedicons.ui.theme.TerraCotta
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieDynamicProperties
import com.airbnb.lottie.compose.rememberLottieDynamicProperty
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    WindowCompat.setDecorFitsSystemWindows(window, false)

    setContent {
      AnimatedIconsTheme {
        App()
      }
    }
  }
}

@Composable
fun App() {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Color.White)
      .windowInsetsPadding(WindowInsets.statusBars),
    contentAlignment = Alignment.Center
  ) {
    Column(
      modifier = Modifier.fillMaxSize(),
      verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
      ) {
        AnimatedTrashButton()
        AnimatedCelebrationButton()
        AnimatedWifiButton()
        AnimatedNotificationButton()
      }
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
      ) {
        AnimatedPlantButton()
        AnimatedCelebrationColoredButton()
        AnimatedMonsterButton()
        AnimatedEyeButton()
      }
    }
  }
}

@Composable
fun AnimatedTrashButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.trash_lottie)
  )
  val dynamicProperties = rememberLottieDynamicProperties(
    rememberLottieDynamicProperty(
      property = LottieProperty.COLOR,
      value = Color.White.toArgb(),
      "**"
    )
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, .21f)
  }

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
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(.21f, .37f),
            initialProgress = .21f
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(24.dp),
      composition = composition.value,
      progress = { progress.value },
      dynamicProperties = dynamicProperties

    )
  }
}

@Composable
fun AnimatedCelebrationButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.celebration_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  val startFrame = .57f
  val endFrame = 1.0f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = Eggshell,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(24.dp),
      composition = composition.value,
      progress = { progress.value }
    )
  }
}

@Composable
fun AnimatedWifiButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.wifi_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()
  val dynamicProperties = rememberLottieDynamicProperties(
    rememberLottieDynamicProperty(
      property = LottieProperty.COLOR,
      value = Color.White.toArgb(),
      "**"
    ),
    rememberLottieDynamicProperty(
      property = LottieProperty.STROKE_COLOR,
      value = Color.White.toArgb(),
      "**"
    )
  )

  val startFrame = .75f
  val endFrame = 1.0f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = Independence,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(24.dp),
      composition = composition.value,
      progress = { progress.value },
      dynamicProperties = dynamicProperties
    )
  }
}

@Composable
fun AnimatedNotificationButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.notification_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  val startFrame = .36f
  val endFrame = .63f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = GreenSheen,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(24.dp),
      composition = composition.value,
      progress = { progress.value },
    )
  }
}

@Composable
fun AnimatedPlantButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.plant_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  val startFrame = 0.0f
  val endFrame = 0.83f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(40.dp),
      composition = composition.value,
      progress = { progress.value }
    )
  }
}

@Composable
fun AnimatedCelebrationColoredButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.celebration_colored_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  val startFrame = 0.0f
  val endFrame = 1.0f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(40.dp),
      composition = composition.value,
      progress = { progress.value }
    )
  }
}

@Composable
fun AnimatedMonsterButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.monster_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  val startFrame = 0.0f
  val endFrame = 0.89f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(40.dp),
      composition = composition.value,
      progress = { progress.value }
    )
  }
}

@Composable
fun AnimatedEyeButton() {
  val composition = rememberLottieComposition(
    spec = LottieCompositionSpec.RawRes(R.raw.eye_lottie)
  )

  val scope = rememberCoroutineScope()
  val progress = rememberLottieAnimatable()

  val startFrame = 0.0f
  val endFrame = 1.0f

  LaunchedEffect(Unit) {
    progress.snapTo(composition.value, startFrame)
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(
        color = Color.LightGray,
        shape = RoundedCornerShape(16.dp)
      )
      .clip(RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          val comp = composition.await()
          progress.animate(
            composition = comp,
            clipSpec = LottieClipSpec.Progress(startFrame, endFrame),
            initialProgress = startFrame
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(40.dp),
      composition = composition.value,
      progress = { progress.value }
    )
  }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
  AnimatedIconsTheme {
    App()
  }
}

@Preview
@Composable
fun RivePreview() {
  val scope = rememberCoroutineScope()
  var clicked by remember { mutableStateOf(false) }

  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Box(
      modifier = Modifier
        .size(60.dp)
        .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
        .clip(RoundedCornerShape(16.dp))
        .clickable {
          scope.launch {
            clicked = true
            delay(1500)
            clicked = false
          }
        },
      contentAlignment = Alignment.Center
    ) {
      AndroidView(
        modifier = Modifier.size(24.dp),
        factory = { context ->
          RiveAnimationView(context).apply {
            setRiveResource(R.raw.trash_can)
          }
        },
        update = { view ->
          view.setBooleanState("Main State Machine", "clicked", clicked)
        }
      )
    }
  }
}