package com.tofu.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tofu.happybirthday.ui.theme.AndroidComposeExpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // 启用边缘到边缘模式，让应用内容可以延伸到系统导航栏和状态栏下方。
        setContent {
            AndroidComposeExpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), // 填充整个屏幕。
                    color = MaterialTheme.colorScheme.background // 设置背景颜色为主题定义的背景颜色。
                ) {
                    GreetingText( // 调用GreetingText函数。
                        message = "Happy Birthday Sam!", // 传递生日祝福消息。
                        from = "From Emma", // 传递发送者信息。
                        modifier = Modifier.padding(8.dp) // 添加8dp的内边距。
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column( // 使用Column布局，垂直排列元素。
        verticalArrangement = Arrangement.Center, // 垂直居中排列元素。
        modifier = modifier // 应用传入的modifier。
    ) {
        Text(
            text = message, // 设置文本内容为生日祝福消息。
            fontSize = 100.sp, // 设置字体大小为100sp。
            lineHeight = 116.sp, // 设置行高为116sp。
            textAlign = TextAlign.Center // 设置文本对齐方式为居中。
        )
        Text(
            text = from, // 设置文本内容为发送者信息。
            fontSize = 36.sp, // 设置字体大小为36sp。
            modifier = Modifier
                .padding(16.dp) // 添加16dp的内边距。
                .align(alignment = Alignment.End) // 设置文本对齐方式为右对齐。
        )
    }
}

@Preview(showBackground = true) // 启用预览，并显示背景。
@Composable
fun GreetingPreview() {
    AndroidComposeExpTheme { // 使用应用主题。
        GreetingText(message = "Happy Birthday Sam!", from = "From Emma") // 调用GreetingText函数，传递测试数据。
    }
}