package com.joniaranguri.resumeapp.screens.about.hobbies

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
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
import com.joniaranguri.resumeapp.model.courseList
import com.joniaranguri.resumeapp.ui.theme.getColor

@Composable
fun HobbiesSection() {
    Column(modifier = Modifier.padding(bottom = 32.dp)) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "My Hobbies",
            style = MaterialTheme.typography.titleLarge,
        )
        HobbiesList(LocalContext.current)
    }
}

@Composable
fun HobbiesList(context: Context) {
    LazyRow {
        itemsIndexed(courseList) { _, hobby ->
            Column(
                modifier = Modifier
                    .fillParentMaxWidth(.6f)
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
                            colorFilter = ColorFilter.tint(color = getColor(hobby.color))
                        )
                        .padding(bottom = 10.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current).data(hobby.imageURL)
                            .decoderFactory(SvgDecoder.Factory()).build(),
                        contentDescription = "contentDescription",
                        contentScale = ContentScale.Inside,
                    )
                }
                Text(text = hobby.name, style = MaterialTheme.typography.titleSmall)
                Text(text = hobby.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
