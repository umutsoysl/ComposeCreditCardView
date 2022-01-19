package com.umut.soysal.compose.composecreditcardview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import com.umut.soysal.compose.composecreditcardview.ui.theme.ComposeCreditCardViewTheme
import com.umut.soysal.compose.creditcardview.component.CreditCardView
import com.umut.soysal.compose.creditcardview.model.CreditCard

class MainActivity : ComponentActivity() {
    @ExperimentalUnitApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCreditCardViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@ExperimentalUnitApi
@Composable
fun Greeting(name: String) {
    val model = CreditCard(
        creditCardNumber = "5269110185933167",
        holderName = "Zeliha Sena Solmaz",
        expiration = "02/25",
        isNfc = true,
        bankName = "enpara.com",
        textColor = R.color.black,
        cardBackgroundColor = R.color.teal_700
    )
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        CreditCardView(creditCard = model)
    }
}

@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCreditCardViewTheme {
        Greeting("Android")
    }
}