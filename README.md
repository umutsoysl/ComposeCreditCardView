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
implementation 'com.github.umutsoysl:ComposeCreditCardView:1.0.1'
```

# Use

```kotlin
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

License
--------


    Copyright 2022 Umut Soysal.
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
