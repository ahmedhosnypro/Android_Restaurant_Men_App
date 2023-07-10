package org.hyperskill.ordersmenu

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

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

        val recipList = Recip.toMenuItemDataList(recipesNameToStockAmount)
        LazyColumn {
            items(recipList) {
                MenuItem(it)
            }
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            MakeOrder(menuItems = recipList)
        }
    }
}

