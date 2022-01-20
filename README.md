# ComposeCreditCardView
Jetpack Compose Credit Card View Library

## Screenshots 📷
<img src="/arts/demo.jpeg" width="300"> &emsp;

# Setup

Add Jitpack
```java
maven { url 'https://jitpack.io' }
```
Add the dependency
```java
implementation 'com.github.umutsoysl:ComposeCreditCardView:1.0.0'
```

# Use

```java
 val creditCardModel = CreditCard(
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
    
 Row(modifier = Modifier.padding(16.dp)) {
        CreditCardView(creditCard = creditCardModel)
    }
     
```
