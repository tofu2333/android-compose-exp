package com.tofu.quadrant

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.tofu.quadrant.ui.theme.AndroidComposeExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidComposeExpTheme {
                App(
                    modifier = Modifier
                        .statusBarsPadding()
                        .fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            QuadrantCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                title = stringResource(R.string.text_composable_text),
                content = stringResource(R.string.first_quadrant_content_text),
                contentColor = Color(0xFFEADDFF)
            )
            QuadrantCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                title = stringResource(R.string.image_composable_text),
                content = stringResource(R.string.second_quadrant_content_text),
                contentColor = Color(0xFFD0BCFF)
            )
        }
        Row(
            modifier = Modifier.weight(1f)
        ) {
            QuadrantCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                title = stringResource(R.string.row_composable_text),
                content = stringResource(R.string.three_quadrant_content_text),
                contentColor = Color(0xFFB69DF8)
            )
            QuadrantCard(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                title = stringResource(R.string.column_composable_text),
                content = stringResource(R.string.four_quadrant_content_text),
                contentColor = Color(0xFFF6EDFF)
            )
        }
    }
}

@Composable
fun QuadrantCard(
    title: String,
    content: String,
    contentColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = contentColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = title,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = content,
            textAlign = TextAlign.Justify
        )
    }

}

@Preview(showBackground = true)
@Composable
fun QuadrantCardPreview() {
    QuadrantCard(
        title = "Text composable",
        content = "Displays text and follows the recommended Material Design guidelines.",
        contentColor = Color(0xFFEADDFF)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppPreview() {
    AndroidComposeExpTheme {
        App()
    }
}