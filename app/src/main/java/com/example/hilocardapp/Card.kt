package com.example.hilocardapp

import android.graphics.drawable.Drawable
import android.util.Log
import java.util.*
/*
A class for playing cards. Holds the cards suite and valueName as Enums.
Also holds a pictureID and a numerical value(for comparison).
Finally, it holds a String composed of the Enum variables to represent the name of the card,
used for logging, which leads us to the only function in the class - logCard().
All Cards are held by a Deck.
 */
class Card(private val suite: Enum<Suite>,
           private val valueName: Enum<ValueName>,
           val pictureID: Int) {

    val valueInt = valueName.ordinal + 2
    val cardName : String = this.valueName.toString().lowercase()
        .replaceFirstChar {it.titlecase(Locale.getDefault())} + " of\n" +
            this.suite.toString().lowercase()
                .replaceFirstChar {it.titlecase(Locale.getDefault())}

    fun logCard() {
        Log.d("card:", "$cardName $valueInt")
    }
}