package com.joniaranguri.resumeapp.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
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
    imageURL: String,
    color: String
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .paint(
                    painter = rememberAsyncImagePainter(
                        R.drawable.half_round_shape,
                        ImageLoader
                            .Builder(LocalContext.current)
                            .components {
                                add(SvgDecoder.Factory())
                            }
                            .build(),
                        contentScale = ContentScale.FillWidth
                    ),
                    colorFilter = ColorFilter.tint(color = getColor(color))
                )
                .padding(bottom = 10.dp),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(imageURL)
                    .decoderFactory(SvgDecoder.Factory()).build(),
                contentDescription = "$title image",
                contentScale = ContentScale.Inside,
                modifier = imageModifier
            )
        }
        if (title.isNotEmpty()) Text(text = title, style = MaterialTheme.typography.titleSmall)
        if (description.isNotEmpty()) Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
