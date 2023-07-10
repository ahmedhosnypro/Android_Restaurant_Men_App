package org.hyperskill.ordersmenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MenuItem(
    menuItemData: MenuItemData
) {

    val menuItemDataState = remember {
        menuItemData
    }

    val menuItemNameColor = remember {
        derivedStateOf {
            if (menuItemData.amountOrdered.value == menuItemData.amountInStock.value) {
                Color.Red
            } else {
                Color.Black
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = menuItemData.name,
            fontSize = 24.sp,
            color = menuItemNameColor.value
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
                if (menuItemData.amountOrdered.value < menuItemData.amountInStock.value) {
                    menuItemData.amountOrdered.value = ++menuItemDataState.amountOrdered.value
                }
            }) {
            Text(text = "+")
        }

        Text(
            text = "${menuItemDataState.amountOrdered.value}",
            color = menuItemNameColor.value,
            fontSize = 24.sp
        )

        TextButton(
            colors = buttonColors,
            modifier = buttonModifier,
            onClick = {
                if (menuItemData.amountOrdered.value > 0) {
                    menuItemData.amountOrdered.value = --menuItemDataState.amountOrdered.value
                }
            }) {
            Text(text = "-")
        }
    }
}