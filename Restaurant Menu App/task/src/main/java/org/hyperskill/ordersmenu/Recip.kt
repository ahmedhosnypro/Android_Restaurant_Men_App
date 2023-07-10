package org.hyperskill.ordersmenu

import androidx.compose.runtime.mutableStateOf

class Recip {
    companion object {
        fun toMenuItemDataList(recipesNameToStockAmount: Map<String, Int>) =
            recipesNameToStockAmount.map { (name, amountInStock) ->
                MenuItemData(
                    name = name, amountInStock = mutableStateOf(amountInStock)
                )
            }
    }
}