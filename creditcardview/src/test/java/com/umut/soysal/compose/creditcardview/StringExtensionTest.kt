package com.umut.soysal.compose.creditcardview

import org.junit.Test

class StringExtensionTest {

    @Test
    fun `when string toCreditCardFormatter is true`() {
        val simpleCardFormat = "1234 5678 9124 5752"
        val cardNumber = "1234567891245752"

        val resultData = cardNumber.toCreditCardFormatter()
    }
}