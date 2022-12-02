package com.example.hilocardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/*
Used to test draw() and shuffle() functionality during development.
Currently not in use, but I leave it if I want to further develop the app.
 */
class TestActivity : AppCompatActivity() {
    private lateinit var drawButton : Button
    private lateinit var  shuffleButton : Button
    private lateinit var playingDeck: Deck

    private lateinit var currentCard: TextView
    private lateinit var mainDeck: TextView
    private lateinit var discardedCards: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        drawButton = findViewById(R.id.drawButton)
        shuffleButton = findViewById(R.id.shuffleButton)

        currentCard = findViewById(R.id.currentCardTextView)
        mainDeck = findViewById(R.id.mainDeckTextView)
        discardedCards = findViewById(R.id.discardedCardsTextView)

        playingDeck = Deck()
        playingDeck.initDeck()
        playingDeck.shuffleDeck()

        currentCard.text = playingDeck.drawCard().cardName

        mainDeck.text = playingDeck.mainDeck.size.toString()
        discardedCards.text = playingDeck.discardedCards.size.toString()

        drawButton.setOnClickListener {
            currentCard.text = playingDeck.drawCard().cardName
            mainDeck.text = playingDeck.mainDeck.size.toString()
            discardedCards.text = playingDeck.discardedCards.size.toString()

        }

        shuffleButton.setOnClickListener {
            playingDeck.shuffleDeck()
            mainDeck.text = playingDeck.mainDeck.size.toString()
            discardedCards.text = playingDeck.discardedCards.size.toString()
            currentCard.text = "---"

        }
    }
}