package co.rikin.animatedicons.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import co.rikin.animatedicons.R
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
import kotlinx.coroutines.launch

@Composable
fun LottieTrashButton() {
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
fun LottieCelebrationButton() {
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
fun LottieWifiButton() {
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
fun LottieNotificationButton() {
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
fun LottiePlantButton() {
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
fun LottieCelebrationColoredButton() {
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
fun LottieMonsterButton() {
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
fun LottieEyeButton() {
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
