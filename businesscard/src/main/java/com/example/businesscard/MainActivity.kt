package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme() {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB6D0E2))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Alic",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF073042)
            )
            Text(
                text = "Android Developer",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF0047AB)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ContactInfoRow(iconId = android.R.drawable.ic_menu_call, text = "+49 15153392110")
            ContactInfoRow(iconId = android.R.drawable.ic_menu_share, text = "@github/amalorod")
            ContactInfoRow(iconId = android.R.drawable.ic_dialog_email, text = "amalorod@smailuni-koeln.de")
        }
    }
}

@Composable
fun ContactInfoRow(iconId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = iconId),
            contentDescription = null,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(0xFF073042)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}
