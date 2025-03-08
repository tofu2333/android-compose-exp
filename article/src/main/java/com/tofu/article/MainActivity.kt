package com.tofu.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tofu.article.ui.theme.AndroidComposeExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeExpTheme {
                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter =  painterResource(R.drawable.bg_compose_background),
                contentDescription = null
            )

            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.title_text),
                fontSize = 24.sp
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                text = stringResource(R.string.first_paragraph_text),
                textAlign = TextAlign.Justify
            )

            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.second_paragraph_text),
                textAlign = TextAlign.Justify
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    AndroidComposeExpTheme {
        App()
    }
}