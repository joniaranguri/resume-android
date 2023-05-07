package com.joniaranguri.resumeapp.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.ui.theme.accentColor
import eu.wewox.textflow.TextFlow
import eu.wewox.textflow.TextFlowObstacleAlignment


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ValueCard(title: String, description: String, color: Color, imageUrl: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        colors = CardDefaults.cardColors(
            containerColor = color,
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .defaultPadding()
        ) {
            Surface(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.wrapContentSize(),
                color = accentColor
            ) {
                Text(
                    text = "Values",
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                )
                TextFlow(text = "\n$description",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth(),
                    obstacleAlignment = TextFlowObstacleAlignment.TopEnd,
                    obstacleContent = {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current).data(imageUrl)
                                .decoderFactory(SvgDecoder.Factory()).build(),
                            contentDescription = "contentDescription",
                            contentScale = ContentScale.Inside,
                            modifier = Modifier
                                .height(70.dp)
                                .width(110.dp)
                                .padding(5.dp)
                        )
                    })
            }
        }
    }
}
