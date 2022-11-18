package com.example.hilocardapp

/*
A Deck can hold an unlimited number of cards
 */
open class Deck {
    var mainDeck = mutableListOf<Card>()
    var discardedCards = mutableListOf<Card>()

    fun shuffleDeck() {
        for(card in discardedCards) {
            mainDeck.add(card)
        }
        discardedCards.clear()
        mainDeck.shuffle()
    }

    fun drawCard() : Card {
        if(mainDeck.size > 0) {
            discardedCards.add(mainDeck[0])
            mainDeck.removeAt(0)
            return discardedCards.last()
        }
        discardedCards.add(mainDeck[0]) // This is bonkers and needs to be changed!
        mainDeck.removeAt(0)
        return discardedCards.last()
    }

    fun addCard(card: Card) {
        mainDeck.add(card)
    }

    fun addDeck(deck: Deck) {
        for(card in deck.mainDeck) {
            addCard(card)
        }
    }

    fun logDeck() {
        for(card in mainDeck) {
            card.logCard()
        }
    }
}