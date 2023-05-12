package com.joniaranguri.resumeapp.common

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.model.Project
import com.joniaranguri.resumeapp.ui.theme.accentColor
import com.joniaranguri.resumeapp.ui.theme.greenCard
import com.joniaranguri.resumeapp.ui.theme.orangeCard
import com.joniaranguri.resumeapp.ui.theme.yellowCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectFlipCard(
    project: Project,
    color: Color,
    cardFace: CardFace,
    onClick: (CardFace) -> Unit,
    modifier: Modifier = Modifier,
    axis: RotationAxis = RotationAxis.AxisY,
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing,
        )
    )
    Card(
        onClick = { onClick(cardFace) },
        modifier = modifier
            .graphicsLayer {
                if (axis == RotationAxis.AxisX) {
                    rotationX = rotation.value
                } else {
                    rotationY = rotation.value
                }
                cameraDistance = 12f * density
            },
        colors = CardDefaults.cardColors(
            containerColor = color,
        )
    ) {
        if (rotation.value <= 90f) {
            Box(
                Modifier.fillMaxSize()
            ) {
                Front(project)
            }
        } else {
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        if (axis == RotationAxis.AxisX) {
                            rotationX = 180f
                        } else {
                            rotationY = 180f
                        }
                    },
            ) {
                Back(project)
            }
        }
    }
}

@Composable
fun Back(project: Project) {
    val uriHandler = LocalUriHandler.current
    Column(
        modifier = Modifier
            .defaultPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = project.description, style = MaterialTheme.typography.bodyMedium)
        if (project.url != "") Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                uriHandler.openUri(project.url)
            }) {
            Text("View Project")
        }
    }
}

@Composable
fun Front(project: Project) {
    Row {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, bottom = 16.dp, top = 16.dp)
                .fillMaxHeight()
                .fillMaxWidth(.6f),
            verticalArrangement = Arrangement.Top

        ) {
            Surface(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .wrapContentSize()
                    .padding(vertical = 16.dp),
                color = getPillColor(project.status)
            ) {
                Text(
                    text = project.status,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                )
            }
            Text(
                text = project.name,
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = project.type,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(project.logo)
                    .crossfade(500)
                    .decoderFactory(SvgDecoder.Factory()).build(),
                contentDescription = "${project.name}'s logo",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)

            )

        }
    }
}

fun getPillColor(status: String): Color = when (status) {
    "Done" -> greenCard
    "Working" -> yellowCard
    "Starting" -> orangeCard
    else -> accentColor
}


enum class CardFace(val angle: Float) {
    Front(0f) {
        override val next: CardFace
            get() = Back
    },
    Back(180f) {
        override val next: CardFace
            get() = Front
    };

    abstract val next: CardFace
}

enum class RotationAxis {
    AxisX,
    AxisY,
}
