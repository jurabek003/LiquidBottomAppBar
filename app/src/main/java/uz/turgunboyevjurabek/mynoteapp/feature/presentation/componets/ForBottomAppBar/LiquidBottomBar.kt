package uz.turgunboyevjurabek.mynoteapp.feature.presentation.componets.ForBottomAppBar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.liquidbottomappbar.feature.presentation.componets.CustomBottomNavigation

@Composable
fun LiquidBottomBar(
    renderEffect: androidx.compose.ui.graphics.RenderEffect?,
    fabAnimationProgress: Float = 0f,
    clickAnimationProgress: Float = 0f,
    toggleAnimation: () -> Unit = { }
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(bottom = 5.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        CustomBottomNavigation()
        Circle(
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
            animationProgress = 0.5f
        )

        FabGroup(renderEffect = renderEffect, animationProgress = fabAnimationProgress)
        FabGroup(
            renderEffect = null,
            animationProgress = fabAnimationProgress,
            toggleAnimation = toggleAnimation
        )
        Circle(
            color = Color.White,
            animationProgress = clickAnimationProgress
        )
    }
}