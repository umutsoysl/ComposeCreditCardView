package com.umut.soysal.compose.composecreditcardview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
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
                    CreateCreditCard()
                }
            }
        }
    }
}

@ExperimentalUnitApi
@Composable
fun CreateCreditCard() {
    val imageCardModel = CreditCard(
        creditCardNumber = "5269110112456678",
        holderName = "Umut Surname",
        expiration = "02/25",
        isNfc = true,
        //bankLogo = R.drawable.ngbank,
        bankName = "ing bank",
        textColor = R.color.black,
        cardBackgroundImageResource = R.drawable.bg
        //cardBackgroundColor = R.color.teal_700
    )

    val colorCardModel = CreditCard(
        creditCardNumber = "4269110112456678",
        holderName = "Umut Surname",
        expiration = "02/25",
        isNfc = true,
        bankLogo = R.drawable.ngbank,
        //bankName = "ing bank",
        textColor = R.color.black,
        //cardBackgroundImageResource = R.drawable.bg
        cardBackgroundColor = R.color.teal_700
    )

    Column(
    ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            CreditCardView(creditCard = imageCardModel)
        }
        Row(
            modifier = Modifier.padding(16.dp)
        ) {
            CreditCardView(creditCard = colorCardModel)
        }
    }
}

@ExperimentalUnitApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCreditCardViewTheme {
        CreateCreditCard()
    }
}