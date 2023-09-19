package com.joniaranguri.resumeapp.screens.contact

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.google.firebase.analytics.FirebaseAnalytics
import com.joniaranguri.resumeapp.R
import com.joniaranguri.resumeapp.ResumeApplication
import com.joniaranguri.resumeapp.common.HtmlCustomText
import com.joniaranguri.resumeapp.common.ShimmerCircle
import com.joniaranguri.resumeapp.common.ShimmerText
import com.joniaranguri.resumeapp.common.ext.defaultPadding
import com.joniaranguri.resumeapp.model.ContactSection
import com.joniaranguri.resumeapp.model.Social
import com.joniaranguri.resumeapp.screens.contact.ContactViewModel.Companion.ANALYTICS_EVENT_SOCIAL_ITEM
import com.joniaranguri.resumeapp.ui.theme.accentColor
import com.joniaranguri.resumeapp.ui.theme.contactColor
import com.joniaranguri.resumeapp.ui.theme.md_theme_dark_background

@Composable
fun ContactScreen(viewModel: ContactViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val contactSection by viewModel.contactSection
    val isLoading by viewModel.isLoading

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentPadding = PaddingValues(bottom = 32.dp)
        ) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(contactColor)
                        .padding(top = 40.dp)
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
                    if (isLoading) ShimmerText(
                        modifier = descriptionModifier
                    )
                    else HtmlCustomText(
                        text = contactSection.description,
                        modifier = descriptionModifier
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    MessageSection(
                        context,
                        contactSection,
                        viewModel::onMessageChange,
                        viewModel::sendMessage,
                        isLoading
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    SocialList(contactSection.socialList, isLoading)
                }
            }
        }
    }
}

@Composable
fun SocialList(socialList: List<Social>, isLoading: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultPadding(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        if (isLoading) {
            repeat(3) {
                ShimmerCircle(50.dp)
            }
        } else SocialContent(socialList)
    }
}

@Composable
fun SocialContent(socialList: List<Social>) {
    val uriHandler = LocalUriHandler.current
    socialList.forEach {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(it.logo)
                .crossfade(500)
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
                .clickable {
                    FirebaseAnalytics
                        .getInstance(ResumeApplication.instance)
                        .logEvent(ANALYTICS_EVENT_SOCIAL_ITEM, Bundle().apply {
                            putString("name", it.name)
                        })
                    uriHandler.openUri(it.targetUrl)
                }
        )
    }
}

@Composable
fun MessageSection(
    context: Context,
    contactSection: ContactSection,
    onNewValue: (String) -> Unit,
    sendMessage: () -> Boolean,
    isLoading: Boolean
) {
    Column(modifier = Modifier.defaultPadding()) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.onSecondary
            ),
            value = contactSection.message,
            placeholder = {
                if (isLoading) ShimmerText(lines = 2)
                else Text(text = "Some awesome message..")
            },
            onValueChange = { onNewValue(it) })
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .defaultPadding(),
            onClick = {
                if (sendMessage()) sendWhatsappMessage(
                    context,
                    contactSection.phoneNumber,
                    contactSection.message
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

val descriptionModifier = Modifier.padding(
    start = 16.dp,
    end = 16.dp,
    top = 40.dp,
    bottom = 70.dp
)