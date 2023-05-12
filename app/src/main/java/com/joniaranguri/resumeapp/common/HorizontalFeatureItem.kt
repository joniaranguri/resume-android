package com.joniaranguri.resumeapp.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.joniaranguri.resumeapp.R
import com.joniaranguri.resumeapp.ui.theme.getColor

@Composable
fun HorizontalFeatureItem(
    modifier: Modifier,
    imageModifier: Modifier,
    title: String = "",
    description: String = "",
    imageURL: String = "",
    color: String,
    isLoading: Boolean,
    minImageHeight: Dp,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(
        horizontalAlignment = horizontalAlignment,
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .paint(
                    painter = rememberAsyncImagePainter(
                        R.drawable.half_round_shape,
                        contentScale = ContentScale.FillWidth
                    ),
                    colorFilter = ColorFilter.tint(color = getColor(color))
                )
                .padding(bottom = 10.dp),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageURL)
                    .crossfade(500)
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = "$title image",
                contentScale = ContentScale.Inside,
                modifier = imageModifier.defaultMinSize(minHeight = minImageHeight)
            )
        }
        if (title.isNotEmpty())
            if (isLoading) ShimmerText(Modifier.padding(top = 16.dp), 1) else {
                Text(text = title, style = MaterialTheme.typography.titleSmall)
            }
        if (title.isNotEmpty())
            if (isLoading) ShimmerText(lines = 2) else Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )

    }
}
