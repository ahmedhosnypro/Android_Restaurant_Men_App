package org.hyperskill.ordersmenu

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class MenuItemData(
    val name: String,
    val amountInStock: MutableState<Int>,
    var amountOrdered: MutableState<Int> = mutableStateOf(0)
)