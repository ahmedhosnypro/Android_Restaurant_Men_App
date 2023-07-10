package org.hyperskill.ordersmenu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

val recipesNameToStockAmount = mapOf(
    "Fettuccine" to 5,
    "Risotto" to 6,
    "Gnocchi" to 4,
    "Spaghetti" to 3,
    "Lasagna" to 5,
    "Steak Parmigiana" to 2
)

@Preview(
    showBackground = true,
    showSystemUi = true,
)
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
        LazyColumn{
            items(recipesNameToStockAmount.keys.toList()) { recipeName ->
                MenuItem(
                    name = recipeName,
                    stock = recipesNameToStockAmount[recipeName] ?: 0
                )
            }
        }
    }
}

@Composable
fun MenuItem(
    name: String, stock: Int = 5
) {
    var amountOrdered by rememberSaveable {
        mutableStateOf(0)
    }

    val amountInStock by rememberSaveable {
        mutableStateOf(stock)
    }

    var menuItemNameColor by remember {
        mutableStateOf(Color.Black)
    }

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            color = menuItemNameColor
        )

        val buttonColors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = Color.Black
        )

        val buttonModifier = Modifier
            .widthIn(min = 10.dp)


        TextButton(
            colors = buttonColors,
            modifier = buttonModifier,
            onClick = {
                if (amountOrdered < amountInStock) {
                    amountOrdered++
                    if (amountOrdered == amountInStock) {
                        menuItemNameColor = Color.Red
                    }
                }
            }) {
            Text(text = "+")
        }

        Text(
            text = "$amountOrdered", color = menuItemNameColor, fontSize = 24.sp
        )

        TextButton(
            colors = buttonColors,
            modifier = buttonModifier,
            onClick = {
                if (amountOrdered > 0) {
                    amountOrdered--
                    if (amountOrdered < amountInStock) {
                        menuItemNameColor = Color.Black
                    }
                }
            }) {
            Text(text = "-")
        }
    }
}