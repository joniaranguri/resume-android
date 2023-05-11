package com.joniaranguri.resumeapp.common

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.joniaranguri.resumeapp.ui.theme.shimmerTextColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShimmerCard(height: Dp = 200.dp) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .shimmerEffect()
        )

    }
}

@Composable
fun ShimmerCircle(size: Dp) {
    Box(
        modifier = Modifier
            .clip(
                CircleShape
            )
            .size(size)
            .shimmerEffect()
    )
}

@Composable
fun ShimmerText(modifier: Modifier = Modifier, lines: Int = 5) {
    Column(verticalArrangement = Arrangement.Center, modifier = modifier) {
        repeat(lines) {
            Spacer(
                modifier = Modifier
                    .height(12.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .shimmerEffect(
                        listOf(
                            shimmerTextColor,
                            MaterialTheme.colorScheme.background,
                            shimmerTextColor,
                        )
                    )
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

fun Modifier.shimmerEffect(colors: List<Color> = emptyList()): Modifier = composed {
    val colorsList = colors.ifEmpty {
        listOf(
            MaterialTheme.colorScheme.onSecondary,
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.onSecondary,
        )
    }
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOffsetX by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )

    background(
        brush = Brush.linearGradient(
            colors = colorsList,
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    ).onGloballyPositioned {
        size = it.size
    }
}
