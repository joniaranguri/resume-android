package com.joniaranguri.resumeapp.screens.contact

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.joniaranguri.resumeapp.R
import com.joniaranguri.resumeapp.common.HtmlCustomText
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.model.Social
import com.joniaranguri.resumeapp.model.contactSection
import com.joniaranguri.resumeapp.ui.theme.accentColor
import com.joniaranguri.resumeapp.ui.theme.contactColor
import com.joniaranguri.resumeapp.ui.theme.md_theme_dark_background

@Composable
fun ContactScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(contactColor)
                .padding(top = 40.dp),
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(contactColor)
                ) {
                    Text(
                        text = "Contact",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                    Text(
                        text = "me :)",
                        style = MaterialTheme.typography.titleLarge,
                        color = accentColor,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                }

            }
            item {
                Box(
                    modifier = Modifier
                        .background(md_theme_dark_background)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .paint(
                            painter = rememberAsyncImagePainter(R.drawable.contact_bg),
                            contentScale = ContentScale.FillBounds
                        ),
                ) {
                    HtmlCustomText(
                        text = contactSection.description,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 40.dp,
                            bottom = 70.dp
                        )
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    MessageSection(context)
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    SocialList(contactSection.data.socialList)
                }
            }
        }
    }
}

@Composable
fun SocialList(socialList: List<Social>) {
    val uriHandler = LocalUriHandler.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultPadding()
            .padding(bottom = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        socialList.forEach {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(it.logo)
                    .decoderFactory(SvgDecoder.Factory()).build(),
                contentDescription = "${it.name}'s logo",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .clip(
                        CircleShape
                    )
                    .background(MaterialTheme.colorScheme.onBackground)
                    .height(50.dp)
                    .width(50.dp)
                    .padding(vertical = 5.dp)
                    .clickable { uriHandler.openUri(it.targetUrl) }
            )
        }
    }
}

@Composable
fun MessageSection(context: Context) {
    var text by remember { mutableStateOf(TextFieldValue(contactSection.data.message)) }
    Column(modifier = Modifier.defaultPadding()) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.onSecondary
            ),
            value = text,
            placeholder = {
                Text(text = "Some awesome message..")
            },
            onValueChange = { text = it })
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .defaultPadding(),
            onClick = {
                sendWhatsappMessage(
                    context,
                    contactSection.data.phoneNumber,
                    text.text
                )
            }) {
            Text(text = "Send message")

        }
    }
}

fun sendWhatsappMessage(context: Context, phoneNumber: String, message: String) {
    context.startActivity(
        Intent(
            Intent.ACTION_VIEW,
            Uri.parse(
                String.format(
                    "https://api.whatsapp.com/send?phone=%s&text=%s",
                    phoneNumber,
                    message
                )
            )
        )
    )
}
