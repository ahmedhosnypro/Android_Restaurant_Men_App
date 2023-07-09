package org.hyperskill.ordersmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import org.hyperskill.ordersmenu.theme.PlayOrdersMenuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlayOrdersMenuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    OrderMenu()
                }
            }
        }
    }
}

//material 3 dark theme



@Preview
@Composable
fun OrderMenu() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            "Orders Menu",
            textAlign = TextAlign.Center,
            fontSize = 48.sp,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Fettuccine",
            fontSize = 24.sp,
        )

    }

}