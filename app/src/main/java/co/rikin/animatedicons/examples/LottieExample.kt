package co.rikin.animatedicons.examples

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.rikin.animatedicons.R
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

@Preview
@Composable
fun LottieIcon() {
  val scope = rememberCoroutineScope()
  val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.trash_lottie))
  val properties = rememberLottieDynamicProperties(
    rememberLottieDynamicProperty(
      property = LottieProperty.COLOR,
      value = Color.White.toArgb(),
      "**"
    )
  )
  val progress = rememberLottieAnimatable()

  val start = 0.22f
  val end = 0.36f

  LaunchedEffect(key1 = Unit) {
    progress.snapTo(composition, progress = start)
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
          progress.animate(composition, clipSpec = LottieClipSpec.Progress(start, end))
        }
      },
    contentAlignment = Alignment.Center
  ) {
    LottieAnimation(
      modifier = Modifier.size(24.dp),
      composition = composition,
      progress = { progress.value },
      dynamicProperties = properties
    )
  }
}
