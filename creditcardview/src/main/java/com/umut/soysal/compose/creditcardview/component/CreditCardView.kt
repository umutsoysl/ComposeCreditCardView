package com.umut.soysal.compose.creditcardview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.umut.soysal.compose.creditcardview.model.CreditCard
import com.umut.soysal.compose.creditcardview.toCreditCardFormatter
import com.umut.soysal.compose.creditcardview.R

@Composable
private fun CardComponent(
    backgroundColor: Color = Color.Black,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .testTag("creditCardContainer"),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.credit_card_round_corner)),
        backgroundColor = backgroundColor
    ) {
        content()
    }
}

@Composable
fun CreditCardView(
    creditCard: CreditCard
) {
    CardComponent {
        ConstraintLayout {
            val (
                iChip,
                lCardNumber,
                lExpiration,
                lExpirationDate,
                lHolderName,
                iCardEntity
            ) = createRefs()

            val cardPadding = dimensionResource(R.dimen.credit_card_padding)
            
            Image(
                painter = painterResource(id = R.drawable.chip),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(iChip) {
                        top.linkTo(parent.top, margin = 50.dp)
                        start.linkTo(parent.start, margin = cardPadding)
                    }
                    .width(60.dp)
            )

            Image(
                modifier = Modifier
                    .constrainAs(iCardEntity) {
                        bottom.linkTo(parent.bottom, margin = cardPadding)
                        end.linkTo(parent.end, margin = cardPadding)
                    }
                    .width(60.dp)
                    .testTag("iCardEntity"),
                painter = painterResource(id = R.drawable.mastercard),
                contentScale = ContentScale.Fit,
                contentDescription = null,
            )
        }
    }
}

@Preview(name = "Credit card front side")
@Composable
private fun CreditCardPreview() {
    val creditCard = CreditCard(
        creditCardNumber = "412345678912345",
        holderName = "Umut Soysal",
        expiration = "12/23",
        cvc = "123"
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
    ) {
        CreditCardView(creditCard = creditCard)
    }
}

@Preview(name = "Credit card back side")
@Composable
private fun ReverseCreditCardPreview() {
    Column(
        modifier = Modifier.width(500.dp)
    ) {
    }
}