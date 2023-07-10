package org.hyperskill.ordersmenu

import android.widget.Toast
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp

var ORDERED = "Ordered:"

@Composable
fun MakeOrder(menuItems: List<MenuItemData>) {
    val context = LocalContext.current
    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black, contentColor = Color.White
        ),
        onClick = {
            menuItems.any {
                it.amountOrdered.value > 0
            }.let {
                if (it) {
                    menuItems
                        .filter { menuItemData ->
                            menuItemData.amountOrdered.value > 0
                        }
                        .flatMap { menuItemData ->
                            listOf(
                                "==> ${menuItemData.name}: ${menuItemData.amountOrdered.value}"
                            )
                        }
                        .joinToString("\n").let { order ->
                            Toast.makeText(
                                context,
                                "$ORDERED\n$order",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    menuItems.onEach { menuItemData ->
                        menuItemData.amountInStock.value -= menuItemData.amountOrdered.value
                        menuItemData.amountOrdered.value = 0
                    }
                }
            }
        },
    ) {
        Text(
            text = "Make Order", fontSize = 24.sp
        )
    }
}