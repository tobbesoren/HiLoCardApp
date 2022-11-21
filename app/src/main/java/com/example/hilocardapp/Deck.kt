package com.example.hilocardapp

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
        addCardList(discardedCards, mainDeck)
        discardedCards.clear()
        mainDeck.shuffle()
    }

    /*
    Used to draw a card. It moves the next card from mainDeck to disCardedCards.
    If mainDeck is empty, it calls shuffleDeck() first. It returns the drawn card.
     */
    fun drawCard() : Card {
        if(mainDeck.size == 0) {
            shuffleDeck()
        }

        addCard(mainDeck[0], discardedCards)
        mainDeck.removeAt(0)
        return discardedCards.last()
    }

    /*
    Used to add a card to a mutableList of cards
     */
    fun addCard(card: Card, cardListToAddTo: MutableList<Card>) {
        cardListToAddTo.add(card)
    }

    /*
    Used to add a mutableList of cards to another mutableList of cards
     */
    fun addCardList(cardsToAdd: MutableList<Card>, cardListToAddTo: MutableList<Card>) {
        for(card in cardsToAdd) {
            addCard(card, cardListToAddTo)
        }
    }

    /*
    Used to add a deck.mainDeck to this deck's mainDeck.
    Not used for the moment; may be used to play with multiple decks.
     */
    fun addDeck(deck: Deck) {
        addCardList(deck.mainDeck, mainDeck)
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