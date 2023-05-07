package com.joniaranguri.resumeapp.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.joniaranguri.resumeapp.model.Education


@Composable
fun EducationItem(education: Education) {
    val uriHandler = LocalUriHandler.current
    Row {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(education.institutionLogo)
                .decoderFactory(SvgDecoder.Factory()).build(),
            contentDescription = "${education.institution}'s logo",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .clip(
                    CircleShape
                )
                .background(MaterialTheme.colorScheme.onBackground)
                .height(85.dp)
                .width(85.dp)
                .padding(vertical = 5.dp)
                .clickable { uriHandler.openUri(education.website) }
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = education.institution,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = education.career,
                style = MaterialTheme.typography.titleSmall,
            )
            Text(
                text = education.period,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}
