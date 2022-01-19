package com.umut.soysal.compose.creditcardview.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.umut.soysal.compose.creditcardview.model.CreditCard
import com.umut.soysal.compose.creditcardview.toCreditCardFormatter
import com.umut.soysal.compose.creditcardview.R
import com.umut.soysal.compose.creditcardview.ui.theme.typography

@Composable
private fun CardComponent(
    backgroundColor: Color = Color.Transparent,
    backgroundImage: Int = 0,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .heightIn(0.dp, 250.dp)
            .testTag("creditCardContainer"),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.credit_card_round_corner)),
        contentColor = backgroundColor,
        elevation = 3.dp
    ) {
        if(backgroundImage>0) {
            Image(
                modifier = Modifier.size(300.dp, 240.dp),
                painter = painterResource(id = backgroundImage),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
        }
        content()
    }
}

@ExperimentalUnitApi
@Composable
fun CreditCardView(
    creditCard: CreditCard
) {
    CardComponent(
        backgroundColor = Color(creditCard.cardBackgroundColor),
        backgroundImage = creditCard.cardBackgroundImageResource
    ) {
        ConstraintLayout(
            modifier = Modifier.background(
                Color(creditCard.cardBackgroundColor)
            )
        ) {
            val (
                iChip,
                iNfc,
                lCardNumber,
                lExpiration,
                lExpirationDate,
                lHolderName,
                iCardEntity,
                lBankName
            ) = createRefs()

            val cardPadding = dimensionResource(R.dimen.credit_card_padding)

            Text(
                modifier = Modifier
                    .constrainAs(lBankName) {
                        top.linkTo(parent.top, margin = 20.dp)
                        start.linkTo(parent.start, margin = cardPadding)
                    }
                    .testTag("lBankName"),
                fontWeight = FontWeight.Light,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
                color = Color(creditCard.textColor),
                text = if(creditCard.bankName.isEmpty()) "BANK NAME" else creditCard.bankName.uppercase()
            )

            if(creditCard.isNfc) {
                Icon(
                    modifier = Modifier
                        .constrainAs(iNfc) {
                            top.linkTo(parent.top, margin = 20.dp)
                            end.linkTo(parent.end, margin = 6.dp)
                        }
                        .width(40.dp)
                        .testTag("iNfc"),
                    painter = painterResource(id = R.drawable.nfc_icon),
                    tint = Color(creditCard.textColor),
                    contentDescription = null,
                )
            }
            
            Image(
                painter = painterResource(id = R.drawable.chip),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(iChip) {
                        top.linkTo(parent.top, margin = 50.dp)
                        start.linkTo(parent.start, margin = cardPadding)
                    }
                    .size(width = 70.dp, height = 50.dp)
            )

            AutoSizeText(
                modifier = Modifier
                    .constrainAs(lCardNumber) {
                        top.linkTo(iChip.bottom)
                        start.linkTo(iChip.start, margin = 9.dp)
                    }
                    .testTag("lCardNumber"),
                textStyle = typography.h1,
                textColor = creditCard.textColor,
                text = if(creditCard.creditCardNumber.isEmpty()) "YOUR CREDIT NO" else creditCard.creditCardNumber.toCreditCardFormatter()
            )

            val holderNameMargin = dimensionResource(R.dimen.credit_card_holder_name_margin)
            AutoSizeText(
                modifier = Modifier
                    .constrainAs(lHolderName) {
                        bottom.linkTo(parent.bottom, margin = 20.dp)
                        top.linkTo(lExpirationDate.bottom)
                        start.linkTo(iChip.start, margin = holderNameMargin)
                    }
                    .testTag("lHolderName"),
                textStyle = typography.h4,
                textColor = creditCard.textColor,
                text = if(creditCard.holderName.isEmpty()) "YOUR NAME" else creditCard.holderName.uppercase()
            )

            Text(
                modifier = Modifier
                    .constrainAs(lExpiration) {
                        top.linkTo(lCardNumber.bottom)
                        start.linkTo(iChip.end, margin = 90.dp)
                    },
                fontSize = 7.sp,
                color = Color(creditCard.textColor),
                text = "VALID\nTHRU"
            )

            Text(
                modifier = Modifier
                    .constrainAs(lExpirationDate) {
                        start.linkTo(iChip.end, margin = 116.dp)
                        top.linkTo(lCardNumber.bottom)
                    }
                    .testTag("lExpirationDate"),
                style = typography.h5,
                color = Color(creditCard.textColor),
                text = if(creditCard.expiration.isEmpty()) "00/00" else creditCard.expiration
            )

            creditCard.logoCardIssuer?.let { icon ->
                Image(
                    modifier = Modifier
                        .constrainAs(iCardEntity) {
                            bottom.linkTo(parent.bottom, margin = cardPadding)
                            end.linkTo(parent.end, margin = cardPadding)
                        }
                        .width(70.dp)
                        .testTag("iCardEntity"),
                    painter = painterResource(id = icon),
                    contentScale = ContentScale.Fit,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun AutoSizeText(
    text: String,
    textStyle: TextStyle,
    modifier: Modifier = Modifier,
    textColor: Int
) {
    var scaledTextStyle by remember { mutableStateOf(textStyle) }
    val txtColor by remember { mutableStateOf(textColor) }
    var readyToDraw by remember { mutableStateOf(false) }

    Text(
        text,
        modifier.drawWithContent {
            if (readyToDraw) {
                drawContent()
            }
        },
        style = scaledTextStyle,
        color = Color(txtColor),
        softWrap = false,
        onTextLayout = { textLayoutResult ->
            if (textLayoutResult.didOverflowWidth) {
                scaledTextStyle =
                    scaledTextStyle.copy(fontSize = scaledTextStyle.fontSize * 0.2)
            } else {
                readyToDraw = true
            }
        }
    )
}


@ExperimentalUnitApi
@Preview(name = "Credit card front side")
@Composable
private fun CreditCardPreview() {
    val creditCard = CreditCard(
        creditCardNumber = "4063863143855721",
        holderName = "Umut Soysal",
        expiration = "12/23",
        cvc = "123",
        bankName = " QNB FINANSBANK",
        cardBackgroundColor = R.color.cardview_shadow_end_color
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