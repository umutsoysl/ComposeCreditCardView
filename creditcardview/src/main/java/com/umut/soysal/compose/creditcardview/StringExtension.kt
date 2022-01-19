package com.umut.soysal.compose.creditcardview

import com.umut.soysal.compose.creditcardview.model.CardType
import java.lang.StringBuilder
import java.util.regex.Pattern

private val MAX_CARD_LENGTH = 19
private val SPACE = " "
private val BLOCK_CHAR_SIZE = 4

fun String?.toCreditCardFormatter(): String {

    this?.apply {
        val result = StringBuilder()
        for (i in this.indices) {
            if (i % BLOCK_CHAR_SIZE == 0 && i != 0) {
                result.append(SPACE)
            }
            result.append(this[i])
        }
        return result.toString()
    }

    return  ""
}

fun String?.isCardNumberValid(): Boolean {
    if(this.isNullOrEmpty()) return false

    val regExpn = ("(\\+[0-9]+[\\- \\.]*)?" + "(\\([0-9]+\\)[\\- \\.]*)?" + "([0-9][0-9\\- \\.][0-9\\- \\.]+[0-9])")
    val pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE)
    val matcher = pattern.matcher(this)

    return matcher.matches() && this.length >= MAX_CARD_LENGTH
}

fun String?.toCreditCardType(): CardType {
    this?.apply {
        return when {
            isVisa(this) -> CardType.VISA
            isMastercard(this) -> CardType.MASTERCARD
            isAmericanExpress(this) -> CardType.AMERICAN_EXPRESS
            else -> CardType.OTHER
        }
    }
    return CardType.OTHER
}

private fun isVisa(number: String) = number.isNotEmpty() && number.substring(0, 1).toIntOrNull() == 4

/**
 * from 51 to 55, until excludes 56
 * */
private fun isMastercard(number: String) = number.length >= 2 && number.substring(0, 2).toIntOrNull() in 51 until 56

/**
 * from 34 to 37, until excludes 38
 * */
private fun isAmericanExpress(number: String) = number.length >= 2 && number.substring(0, 2).toIntOrNull() in 34 until 38