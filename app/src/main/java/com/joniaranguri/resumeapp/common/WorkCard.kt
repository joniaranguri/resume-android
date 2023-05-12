package com.joniaranguri.resumeapp.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.joniaranguri.resumeapp.R
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.graphs.ScreenRoute
import com.joniaranguri.resumeapp.model.Work
import com.joniaranguri.resumeapp.ui.theme.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkCard(work: Work, openScreen: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { openScreen("${ScreenRoute.WorkDetail.route}/${work.workId}") }, //TODO: Use real id
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.onTertiary,
        ),
    ) {
        Row(
            modifier = Modifier.height(130.dp),
        ) {
            Column(
                modifier = Modifier
                    .defaultPadding()
                    .fillMaxWidth(.65f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = work.companyName,
                    fontSize = 12.sp,
                    style = MaterialTheme.typography.titleLarge,
                )
                Text(
                    text = work.title,
                    style = MaterialTheme.typography.titleSmall,
                )
                Text(
                    text = work.period,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .paint(
                        painter = rememberAsyncImagePainter(R.drawable.half_circle_right),
                        contentScale = ContentScale.FillBounds
                    ),
                contentAlignment = Alignment.Center,
            ) {

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(work.companyLogo)
                        .crossfade(500)
                        .decoderFactory(SvgDecoder.Factory()).build(),
                    contentDescription = "${work.companyName}'s logo",
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)

                )

            }
        }

    }
}
