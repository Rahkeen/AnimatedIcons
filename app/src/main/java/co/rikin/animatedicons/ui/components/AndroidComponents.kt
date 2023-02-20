package co.rikin.animatedicons.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
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
import co.rikin.animatedicons.ui.theme.GreenSheen
import co.rikin.animatedicons.ui.theme.Independence
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
      Path(
        pathData = lidPathData,
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

    Group(
      name = "CanVector",
      pivotX = viewportWidth / 2,
      pivotY = viewportHeight / 2,
      translationY = canTranslationY.value,
      rotation = canRotation.value
    ) {
      Path(
        pathData = canPathData,
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
fun CustomMenuButton() {
  val scope = rememberCoroutineScope()
  val lineOneTranslationX = remember {
    Animatable(0f)
  }
  val lineTwoTranslationX = remember {
    Animatable(0f)
  }
  val lineThreeTranslationX = remember {
    Animatable(0f)
  }

  val lineOne = PathData {
    moveTo(3.0f, 7.0f)
    curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f)
    horizontalLineToRelative(16.0f)
    curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
    reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f)
    lineTo(4.0f, 6.0f)
    curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
    close()
  }
  val lineTwo = PathData {
    moveTo(4.0f, 13.0f)
    horizontalLineToRelative(16.0f)
    curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
    reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f)
    lineTo(4.0f, 11.0f)
    curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
    reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f)
    close()
  }
  val lineThree = PathData {
    moveTo(4.0f, 18.0f)
    horizontalLineToRelative(16.0f)
    curveToRelative(0.55f, 0.0f, 1.0f, -0.45f, 1.0f, -1.0f)
    reflectiveCurveToRelative(-0.45f, -1.0f, -1.0f, -1.0f)
    lineTo(4.0f, 16.0f)
    curveToRelative(-0.55f, 0.0f, -1.0f, 0.45f, -1.0f, 1.0f)
    reflectiveCurveToRelative(0.45f, 1.0f, 1.0f, 1.0f)
    close()
  }

  val painter = rememberVectorPainter(
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
    viewportWidth = 24f,
    viewportHeight = 24f,
    autoMirror = false
  ) { viewportWidth, viewportHeight ->
    Group(translationX = lineOneTranslationX.value) {
      Path(pathData = lineOne, fill = SolidColor(Color.White))
    }
    Group(translationX = lineTwoTranslationX.value) {
      Path(pathData = lineTwo, fill = SolidColor(Color.White))
    }
    Group(translationX = lineThreeTranslationX.value) {
      Path(pathData = lineThree, fill = SolidColor(Color.White))
    }
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(color = Independence, shape = RoundedCornerShape(16.dp))
      .clip(shape = RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          lineOneTranslationX.animateTo(-3f, tween(easing = LinearEasing))
          lineOneTranslationX.animateTo(3f, tween(easing = LinearEasing))
          lineOneTranslationX.animateTo(
            0f,
            spring(
              dampingRatio = Spring.DampingRatioMediumBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
        }
        scope.launch {
          delay(100)
          lineTwoTranslationX.animateTo(-3f, tween(easing = LinearEasing))
          lineTwoTranslationX.animateTo(3f, tween(easing = LinearEasing))
          lineTwoTranslationX.animateTo(
            0f,
            spring(
              dampingRatio = Spring.DampingRatioMediumBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
        }
        scope.launch {
          delay(200)
          lineThreeTranslationX.animateTo(-3f, tween(easing = LinearEasing))
          lineThreeTranslationX.animateTo(3f, tween(easing = LinearEasing))
          lineThreeTranslationX.animateTo(
            0f,
            spring(
              dampingRatio = Spring.DampingRatioMediumBouncy,
              stiffness = Spring.StiffnessLow
            )
          )
        }
      },
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = painter,
      modifier = Modifier.size(24.dp),
      contentDescription = "Delete",
    )
  }
}

@Preview
@Composable
fun CustomSendButton() {
  val scope = rememberCoroutineScope()
  val translationX = remember {
    Animatable(0f)
  }
  val translationY = remember {
    Animatable(0f)
  }

  val scaleY = remember {
    Animatable(1f)
  }

  val pathData = PathData {
    moveTo(3.4f, 20.4f)
    lineToRelative(17.45f, -7.48f)
    curveToRelative(0.81f, -0.35f, 0.81f, -1.49f, 0.0f, -1.84f)
    lineTo(3.4f, 3.6f)
    curveToRelative(-0.66f, -0.29f, -1.39f, 0.2f, -1.39f, 0.91f)
    lineTo(2.0f, 9.12f)
    curveToRelative(0.0f, 0.5f, 0.37f, 0.93f, 0.87f, 0.99f)
    lineTo(17.0f, 12.0f)
    lineTo(2.87f, 13.88f)
    curveToRelative(-0.5f, 0.07f, -0.87f, 0.5f, -0.87f, 1.0f)
    lineToRelative(0.01f, 4.61f)
    curveToRelative(0.0f, 0.71f, 0.73f, 1.2f, 1.39f, 0.91f)
    close()
  }

  val vector = rememberVectorPainter(
    defaultWidth = 24.dp,
    defaultHeight = 24.dp,
    viewportWidth = 24f,
    viewportHeight = 24f,
    autoMirror = true
  ) { viewportWidth, viewportHeight ->
    Group(
//      pivotX = viewportWidth / 2,
//      pivotY = viewportHeight / 2,
      translationX = translationX.value,
      translationY = translationY.value,
      scaleY = scaleY.value
    ) {
      Path(pathData = pathData, fill = SolidColor(Color.White))
    }
  }

  Box(
    modifier = Modifier
      .size(60.dp)
      .background(color = GreenSheen, shape = RoundedCornerShape(16.dp))
      .clip(shape = RoundedCornerShape(16.dp))
      .clickable {
        scope.launch {
          scaleY.animateTo(0.4f, tween())
          translationX.animateTo(24f, tween(durationMillis = 400))
          translationX.snapTo(-24f)
          launch {
            translationX.animateTo(0f, tween(durationMillis = 1000))
          }
          launch {
            scaleY.animateTo(1f, tween(durationMillis = 1500))
          }
        }
      },
    contentAlignment = Alignment.Center
  ) {
    Image(
      painter = vector,
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
        CustomMenuButton()
        CustomSendButton()
      }
    }
  }
}
