package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    val logo = painterResource(R.drawable.android)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BusinessDetails(
            logo = logo,
            title = "Sunny Sahsi",
            tagline = "Android Developer Extraordinaire"
        )
        ContactCardContainer()
    }
}

@Composable
fun BusinessDetails(
    logo: Painter,
    title: String,
    tagline: String,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = logo,
            contentDescription = title,
            modifier = Modifier
                .background(Color(0xff073042))
                .padding(16.dp)
                .width(120.dp)
                .height(120.dp)
        )
        Text(
            text = title,
            fontSize = 45.sp,
            modifier = Modifier,
            fontFamily = FontFamily.SansSerif

        )
        Text(
            text = tagline,
            fontSize = 21.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier,
            color = Color(0xFF0AA850),
            fontWeight = FontWeight.Bold
        )

    }
}

@Composable
fun ContactCardItem(
    icon: Painter,
    contactDetails: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Image(
            painter = icon, contentDescription = contactDetails,
            modifier = Modifier
                .width(25.dp)
                .height(25.dp)
        )
        Text(
            text = contactDetails,
            modifier = Modifier
                .padding(start = 20.dp)
        )
    }
}

@Composable
fun ContactCardContainer() {
    val callIcon = painterResource(R.drawable.call)
    val mailIcon = painterResource(R.drawable.mail)
    val shareIcon = painterResource(R.drawable.share)
    Column {
        ContactCardItem(icon = callIcon, contactDetails = "+91 7759925544")
        ContactCardItem(icon = mailIcon, contactDetails = "sahsisunny@gmail.com")
        ContactCardItem(icon = shareIcon, contactDetails = "@SahsiSunny")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}