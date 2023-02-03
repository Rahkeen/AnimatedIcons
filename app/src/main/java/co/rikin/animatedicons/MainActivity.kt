package co.rikin.animatedicons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import co.rikin.animatedicons.ui.ButtonWithLabel
import co.rikin.animatedicons.ui.CustomTrashButton
import co.rikin.animatedicons.ui.LottieCelebrationButton
import co.rikin.animatedicons.ui.LottieCelebrationColoredButton
import co.rikin.animatedicons.ui.LottieEyeButton
import co.rikin.animatedicons.ui.LottieMonsterButton
import co.rikin.animatedicons.ui.LottieNotificationButton
import co.rikin.animatedicons.ui.LottiePlantButton
import co.rikin.animatedicons.ui.LottieTrashButton
import co.rikin.animatedicons.ui.LottieWifiButton
import co.rikin.animatedicons.ui.RiveTrashButton
import co.rikin.animatedicons.ui.theme.AnimatedIconsTheme

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
    ButtonComparison()
  }
}

@Composable
fun ButtonComparison() {
  Column {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceEvenly,
      verticalAlignment = Alignment.CenterVertically
    ) {
      ButtonWithLabel(label = "Android") {
        CustomTrashButton()
      }
      ButtonWithLabel(label = "Lottie") {
        LottieTrashButton()
      }
      ButtonWithLabel(label = "Rive") {
        RiveTrashButton()
      }
    }
  }
}

@Composable
fun LottieButtons() {
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
      LottieTrashButton()
      LottieCelebrationButton()
      LottieWifiButton()
      LottieNotificationButton()
    }
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
      verticalAlignment = Alignment.CenterVertically
    ) {
      LottiePlantButton()
      LottieCelebrationColoredButton()
      LottieMonsterButton()
      LottieEyeButton()
    }
  }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {
  AnimatedIconsTheme {
    App()
  }
}
