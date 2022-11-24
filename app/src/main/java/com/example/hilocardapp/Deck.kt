package com.example.hilocardapp

import android.util.Log

/*
A Deck can hold an unlimited number of cards in two mutable lists;
mainDeck and discardedCards.
Has functions to draw a card, shuffle deck and add card/s between mutable lists.
 */
open class Deck {
    var mainDeck = mutableListOf<Card>()
    var discardedCards = mutableListOf<Card>()

    /*
    Moves discardedCards to mainDeck and shuffles the list.
     */
    fun shuffleDeck() {
        moveCardList(discardedCards, mainDeck)
        mainDeck.shuffle()
        Log.d("!!!!", "Deck shuffled")
    }

    /*
    Used to draw a card. It moves the next card from mainDeck to disCardedCards.
    If mainDeck is empty, it calls shuffleDeck() first. It returns the drawn card.
     */
    fun drawCard() : Card {
        if(mainDeck.size == 0) {
            shuffleDeck()
        }

        moveCard(mainDeck[0], mainDeck, discardedCards)

        return discardedCards.last()
    }

    /*
    Used to move a card from a mutableList of cards to another
     */
    fun moveCard(card: Card, cardListToAdd : MutableList<Card>, cardListToAddTo: MutableList<Card>) {
        cardListToAddTo.add(card)
        cardListToAdd.removeAt(0)
    }

    /*
    Used to move a mutableList of cards to another mutableList of cards
     */
    fun moveCardList(cardsToAdd: MutableList<Card>, cardListToAddTo: MutableList<Card>) {
        for(i in (0 until cardsToAdd.size)) {
            moveCard(cardsToAdd[0], cardsToAdd, cardListToAddTo)
        }
    }

    /*
    Used to add a deck.mainDeck to this deck's mainDeck.
    Not used for the moment; may be used to play with multiple decks.
     */
    fun addDeck(deck: Deck) {
        moveCardList(deck.mainDeck, mainDeck)
    }

    /*
    Only used for development
     */
    fun logDeck() {
        for(card in mainDeck) {
            card.logCard()
        }
    }
}