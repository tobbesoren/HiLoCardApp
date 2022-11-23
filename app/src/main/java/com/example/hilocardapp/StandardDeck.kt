package com.example.hilocardapp

/*
A StandardDeck has a function to initialize a standard 52 card deck.
 */
class StandardDeck : Deck() {

    fun initDeck() {
//        for(suite in Suite.values()) {
//            for(value in ValueName.values()) {
//                val card = Card(suite, value)
//                mainDeck.add(card)
//            }
//        }

        mainDeck.add(Card(Suite.CLUBS, ValueName.TWO, R.drawable.clubs_02))
        mainDeck.add(Card(Suite.CLUBS, ValueName.THREE, R.drawable.clubs_03))
        mainDeck.add(Card(Suite.CLUBS, ValueName.FOUR, R.drawable.clubs_04))
        mainDeck.add(Card(Suite.CLUBS, ValueName.FIVE, R.drawable.clubs_05))
        mainDeck.add(Card(Suite.CLUBS, ValueName.SIX, R.drawable.clubs_06))
        mainDeck.add(Card(Suite.CLUBS, ValueName.SEVEN, R.drawable.clubs_07))
        mainDeck.add(Card(Suite.CLUBS, ValueName.EIGHT, R.drawable.clubs_08))
        mainDeck.add(Card(Suite.CLUBS, ValueName.NINE, R.drawable.clubs_09))
        mainDeck.add(Card(Suite.CLUBS, ValueName.TEN, R.drawable.clubs_10))
        mainDeck.add(Card(Suite.CLUBS, ValueName.JACK, R.drawable.clubs_11))
        mainDeck.add(Card(Suite.CLUBS, ValueName.QUEEN, R.drawable.clubs_12))
        mainDeck.add(Card(Suite.CLUBS, ValueName.KING, R.drawable.clubs_13))
        mainDeck.add(Card(Suite.CLUBS, ValueName.ACE, R.drawable.clubs_14))

        mainDeck.add(Card(Suite.DIAMONDS, ValueName.TWO, R.drawable.diamonds_02))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.THREE, R.drawable.diamonds_03))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.FOUR, R.drawable.diamonds_04))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.FIVE, R.drawable.diamonds_05))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.SIX, R.drawable.diamonds_06))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.SEVEN, R.drawable.diamonds_07))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.EIGHT, R.drawable.diamonds_08))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.NINE, R.drawable.diamonds_09))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.TEN, R.drawable.diamonds_10))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.JACK, R.drawable.diamonds_11))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.QUEEN, R.drawable.diamonds_12))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.KING, R.drawable.diamonds_13))
        mainDeck.add(Card(Suite.DIAMONDS, ValueName.ACE, R.drawable.diamonds_14))

        mainDeck.add(Card(Suite.HEARTS, ValueName.TWO, R.drawable.hearts_02))
        mainDeck.add(Card(Suite.HEARTS, ValueName.THREE, R.drawable.hearts_03))
        mainDeck.add(Card(Suite.HEARTS, ValueName.FOUR, R.drawable.hearts_04))
        mainDeck.add(Card(Suite.HEARTS, ValueName.FIVE, R.drawable.hearts_05))
        mainDeck.add(Card(Suite.HEARTS, ValueName.SIX, R.drawable.hearts_06))
        mainDeck.add(Card(Suite.HEARTS, ValueName.SEVEN, R.drawable.hearts_07))
        mainDeck.add(Card(Suite.HEARTS, ValueName.EIGHT, R.drawable.hearts_08))
        mainDeck.add(Card(Suite.HEARTS, ValueName.NINE, R.drawable.hearts_09))
        mainDeck.add(Card(Suite.HEARTS, ValueName.TEN, R.drawable.hearts_10))
        mainDeck.add(Card(Suite.HEARTS, ValueName.JACK, R.drawable.hearts_11))
        mainDeck.add(Card(Suite.HEARTS, ValueName.QUEEN, R.drawable.hearts_12))
        mainDeck.add(Card(Suite.HEARTS, ValueName.KING, R.drawable.hearts_13))
        mainDeck.add(Card(Suite.HEARTS, ValueName.ACE, R.drawable.hearts_14))

        mainDeck.add(Card(Suite.SPADES, ValueName.TWO, R.drawable.spades_02))
        mainDeck.add(Card(Suite.SPADES, ValueName.THREE, R.drawable.spades_03))
        mainDeck.add(Card(Suite.SPADES, ValueName.FOUR, R.drawable.spades_04))
        mainDeck.add(Card(Suite.SPADES, ValueName.FIVE, R.drawable.spades_05))
        mainDeck.add(Card(Suite.SPADES, ValueName.SIX, R.drawable.spades_06))
        mainDeck.add(Card(Suite.SPADES, ValueName.SEVEN, R.drawable.spades_07))
        mainDeck.add(Card(Suite.SPADES, ValueName.EIGHT, R.drawable.spades_08))
        mainDeck.add(Card(Suite.SPADES, ValueName.NINE, R.drawable.spades_09))
        mainDeck.add(Card(Suite.SPADES, ValueName.TEN, R.drawable.spades_10))
        mainDeck.add(Card(Suite.SPADES, ValueName.JACK, R.drawable.spades_11))
        mainDeck.add(Card(Suite.SPADES, ValueName.QUEEN, R.drawable.spades_12))
        mainDeck.add(Card(Suite.SPADES, ValueName.KING, R.drawable.spades_13))
        mainDeck.add(Card(Suite.SPADES, ValueName.ACE, R.drawable.spades_14))

        logDeck()
    }
}