package com.example.hilocardapp

/*
A StandardDeck has a function to initialize a standard 52 card deck.
 */
class StandardDeck : Deck() {

    fun initDeck() {
        for(suite in Suite.values()) {
            for(value in ValueName.values()) {
                val card = Card(suite, value)
                mainDeck.add(card)
            }
        }
        logDeck()
    }
}