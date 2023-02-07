package co.rikin.animatedicons.ui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.DefaultFillType
import androidx.compose.ui.graphics.vector.Group
import androidx.compose.ui.graphics.vector.Path
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.rikin.animatedicons.ui.theme.AnimatedIconsTheme
import co.rikin.animatedicons.ui.theme.TerraCotta
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ButtonWithLabel(label: String, content: @Composable () -> Unit) {
  Column(
    modifier = Modifier.wrapContentSize(),
    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    content()
    Text(text = label, style = MaterialTheme.typography.body1, color = Color.Black)
  }
}

@Preview
@Composable
fun CustomTrashButton() {

  val lidPathData = PathData {
    moveTo(18.0f, 4.0f)
    horizontalLineToRelative(-2.5f)
    lineToRelative(-0.71f, -0.71f)
    curveToRelative(-0.18f, -0.18f, -0.44f, -0.29f, -0.7f, -0.29f)
    horizontalLineTo(9.91f)
    curveToRelative(-0.26f, 0.0f, -0.52f, 0.11f, -0.7f, 0.29f)
    lineTo(8.5f, 4.0f)
    horizontalLineTo(6.0f)
    curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
    reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f)
    horizontalLineToRelative(12.0f)
    curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
    reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f)
    close()
  }

  val canPathData = PathData {
    moveTo(6.0f, 19.0f)
    curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
    horizontalLineToRelative(8.0f)
    curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
    verticalLineTo(9.0f)
    curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
    horizontalLineTo(8.0f)
    curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
    verticalLineToRelative(10.0f)
    close()
  }

  val lidParsedPathData = PathParser()
    .parsePathString("M21,5c0,0.55 -0.45,1 -1,1H4C3.45,6 3,5.55 3,5s0.45,-1 1,-1h7V3c0,-0.55 0.45,-1 1,-1s1,0.45 1,1v1h7C20.55,4 21,4.45 21,5z")
    .toNodes()

  val canParsedPathData = PathParser()
    .parsePathString("M4.52,7.5l1.34,12.08C6.01,20.96 7.19,22 8.59,22h6.82c1.4,0 2.58,-1.04 2.73,-2.42L19.48,7.5H4.52zM11,18c0,0.55 -0.45,1 -1,1s-1,-0.45 -1,-1v-6c0,-0.55 0.45,-1 1,-1s1,0.45 1,1V18zM15,18c0,0.55 -0.45,1 -1,1s-1,-0.45 -1,-1v-6c0,-0.55 0.45,-1 1,-1s1,0.45 1,1V18z")
    .toNodes()

  val lidTranslationY = remember {
    Animatable(0f)
  }

  val canRotation = remember {
    Animatable(0f)
  }

  val canTranslationY = remember {
    Animatable(0f)
  }

  val scope = rememberCoroutineScope()

  val iconVector = rememberVectorPainter(
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
    viewportWidth = 24f,
    viewportHeight = 24f,
    autoMirror = true,
  ) { viewportWidth, viewportHeight ->
    Group(
      name = "LidVector",
      translationY = lidTranslationY.value
    ) {
      Group(name = "Lid") {
        Path(
          pathData = lidParsedPathData,
          fill = SolidColor(Color.White),
          fillAlpha = 1f,
          stroke = null,
          strokeAlpha = 1f,
          strokeLineCap = StrokeCap.Butt,
          strokeLineJoin = StrokeJoin.Bevel,
          strokeLineMiter = 1f,
          pathFillType = DefaultFillType
        )
      }
    }

    Group(
      name = "CanVector",
      pivotX = viewportWidth / 2,
      pivotY = viewportHeight / 2,
      translationY = canTranslationY.value,
      rotation = canRotation.value
    ) {
      Group(name = "Can") {
        Path(
          pathData = canParsedPathData,
          fill = SolidColor(Color.White),
          fillAlpha = 1f,
          stroke = null,
          strokeAlpha = 1f,
          strokeLineCap = StrokeCap.Butt,
          strokeLineJoin = StrokeJoin.Bevel,
          strokeLineMiter = 1f,
          pathFillType = DefaultFillType
        )
      }
    }
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(color = TerraCotta, shape = RoundedCornerShape(16.dp))
      .clip(shape = RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          lidTranslationY.animateTo(
            targetValue = -2f,
            animationSpec = spring(
              dampingRatio = Spring.DampingRatioNoBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
          lidTranslationY.animateTo(
            targetValue = 0F,
            animationSpec = spring(
              dampingRatio = Spring.DampingRatioHighBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
        }
        scope.launch {
          delay(700)
          canRotation.animateTo(0f, animationSpec = keyframes {
            durationMillis = 800
            -10f at 200
            10f at 400
            -10f at 600
          })
        }
        scope.launch {
          delay(700)
          canTranslationY.animateTo(
            targetValue = 2f,
            animationSpec = spring(
              dampingRatio = Spring.DampingRatioLowBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
          canTranslationY.animateTo(
            targetValue = 0F,
            animationSpec = spring(
              dampingRatio = Spring.DampingRatioNoBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = iconVector,
      modifier = Modifier.size(24.dp),
      contentDescription = "Delete",
    )
  }
}

@Preview
@Composable
fun HandDrawnButtons() {
  AnimatedIconsTheme {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
      verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
      Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
        CustomTrashButton()
        CustomTrashButton()
        CustomTrashButton()
      }
    }
  }
}
