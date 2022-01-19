package com.umut.soysal.compose.creditcardview.model

import android.graphics.Color
import com.umut.soysal.compose.creditcardview.R
import com.umut.soysal.compose.creditcardview.toCreditCardType

data class CreditCard (
    var creditCardNumber: String,
    var expiration: String = "00/00",
    var holderName: String = "",
    var cvc: String = "000",
    var cardType: String = "VISA",
    var isFrontView: Boolean = true,
    var cardBackgroundImageResource: Int = 0,
    var isNfc: Boolean = true,
    var bankName: String = "",
    var textColor: Int = 0,
    var cardBackgroundColor: Int = Color.TRANSPARENT
){
    val logoCardIssuer = when(creditCardNumber.toCreditCardType()) {
        CardType.VISA -> R.drawable.visa
        CardType.MASTERCARD -> R.drawable.mastercard
        CardType.AMERICAN_EXPRESS -> R.drawable.mastercard
        CardType.OTHER -> R.drawable.mastercard
    }
}

enum class CardType{
    VISA,
    MASTERCARD,
    AMERICAN_EXPRESS,
    OTHER
}