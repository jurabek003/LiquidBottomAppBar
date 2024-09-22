package uz.turgunboyevjurabek.mynoteapp.feature.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asComposeRenderEffect
import uz.turgunboyevjurabek.mynoteapp.feature.presentation.componets.ForBottomAppBar.LiquidBottomBar
import uz.turgunboyevjurabek.mynoteapp.feature.presentation.componets.ForBottomAppBar.getRenderEffect

import uz.turgunboyevjurabek.mynoteapp.feature.presentation.theme.MyNoteAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNoteAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        val isMenuExtended = remember { mutableStateOf(false) }
                        val fabAnimationProgress by animateFloatAsState(
                            targetValue = if (isMenuExtended.value) 1f else 0f,
                            animationSpec = tween(
                                durationMillis = 1000,
                                easing = LinearEasing
                            ), label = ""
                        )
                        val clickAnimationProgress by animateFloatAsState(
                            targetValue = if (isMenuExtended.value) 1f else 0f,
                            animationSpec = tween(
                                durationMillis = 400,
                                easing = LinearEasing
                            ), label = ""
                        )
                        val renderEffect = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                            getRenderEffect().asComposeRenderEffect()
                        } else {
                            null
                        }
                        LiquidBottomBar(
                            renderEffect = renderEffect,
                            fabAnimationProgress = fabAnimationProgress,
                            clickAnimationProgress = clickAnimationProgress
                        ) {
                            isMenuExtended.value = isMenuExtended.value.not()
                        }


                    }
                }
            }
        }
    }
}