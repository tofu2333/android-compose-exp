package com.tofu.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tofu.businesscard.ui.theme.AndroidComposeExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeExpTheme {
                App(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .background(Color(0xFF3ddc84))
                )
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        IconCard("Jennifer Doe", "Android Developer Extraordinaire")
        Spacer(Modifier.weight(1f))
        Column(
            modifier = Modifier
        ) {
            InfoCard("+11 (123) 444 555 666", Icons.Filled.Phone)
            Spacer(Modifier.height(8.dp))
            InfoCard("@AndroidDev", Icons.Filled.Share)
            Spacer(Modifier.height(8.dp))
            InfoCard("jne@android.com", Icons.Filled.Email)
            Spacer(modifier = Modifier.height(64.dp))
        }
    }
}

@Composable
fun IconCard(title: String, description: String,modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(size = 200.dp)
                .background(Color.Blue),
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = title,
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = description,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
    }
}

@Composable
fun InfoCard(title: String, imageVector: ImageVector, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            tint = Color.Green
        )
        Spacer(Modifier.padding(start = 16.dp))
        Text(title, fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview() {
    AndroidComposeExpTheme {
        InfoCard("1234567890", Icons.Filled.Phone)
    }
}

@Preview(showBackground = true)
@Composable
fun IconCardPreview() {
    AndroidComposeExpTheme {
        IconCard("Jennifer Doe", "Android Developer Extraordinaire")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    AndroidComposeExpTheme {
        App()
    }
}