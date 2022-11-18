package com.example.hilocardapp

import android.util.Log
import java.util.*

class Card(private val suite: Enum<Suite>, private val valueName: Enum<ValueName>, ) {
    val valueInt = valueName.ordinal + 2
    var cardName : String = this.valueName.toString().lowercase()
        .replaceFirstChar {it.titlecase(Locale.getDefault())} + " of\n" +
            this.suite.toString().lowercase()
                .replaceFirstChar {it.titlecase(Locale.getDefault())}

    fun logCard() {
        Log.d("card:", "$cardName $valueInt")
    }
}