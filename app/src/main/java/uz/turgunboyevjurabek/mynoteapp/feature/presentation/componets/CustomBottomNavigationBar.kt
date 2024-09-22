package uz.turgunboyevjurabek.mynoteapp.feature.presentation.componets

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun CustomBottomNavigationBar(
    modifier: Modifier
) {
    Box(
        modifier= modifier
            .fillMaxWidth()
            .height(70.dp)
    ) {
        CustomBottomBarBackground(Modifier.fillMaxSize())

        Row(
            modifier=Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {},
                modifier=modifier
            ) {
                Icon(
                    Icons.Default.Menu,
                    contentDescription = null,
                    tint = Color.White,
                    modifier=modifier
                        .size(30.dp)
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            IconButton(
                onClick = { /* TODO */ },
                modifier=modifier
            ) {
                Icon(
                    Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = modifier
                        .size(30.dp)
                )
            }
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { /* FAB action */ },
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-25).dp),
            shape = CircleShape
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
        }
    }
}

@Composable
fun CustomBottomBarBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier) {
        val width = size.width
        val height = size.height

        val path = Path().apply {
            moveTo(0f, 0f)
            lineTo(width * 0.38f, 0f) // Boshlang'ich nuqta (38%)

            // Bezier o'zgaruvchilarni ma'lumotlarga moslashtiring
            val bezierStartX = width * 0.50f // Bezier boshqaruvchi nuqta (chuqurroq)
            val bezierEndX = width * 0.62f // Tugatish nuqtasi (radiusli qirra uchun yaqinroq)
            val bezierDepthMultiplier = 1.2f // Bezier chuqurroq bo'lishi uchun ko'rsatkich
            quadraticBezierTo(bezierStartX, height * bezierDepthMultiplier, bezierEndX, 0f)

            lineTo(width, 0f) // O'ng tomon
            lineTo(width, height) // Pastki qism
            lineTo(0f, height) // Chap tomoni
            close() // Shaklni yopamiz
        }

        clipPath(path) {
            drawRect(
                color = Color.Black,
                size = Size(width, height)
            )
        }
    }

}
