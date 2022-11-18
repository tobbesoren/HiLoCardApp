package com.example.hilocardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var playingDeck: StandardDeck

    private lateinit var card1 : TextView
    private lateinit var card2 : TextView
    private lateinit var scoreTextView : TextView
    private lateinit var triesLeftTextView : TextView
    private lateinit var message : TextView

    var score = 0
    var triesLeft = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        scoreTextView = findViewById(R.id.scoreTextView)
        triesLeftTextView = findViewById(R.id.triesLeftTextView)
        message = findViewById(R.id.messageTextView)

        card1 = findViewById(R.id.card1TextView)
        card2 = findViewById(R.id.card2TextView)

        val hiButton = findViewById<Button>(R.id.higherButton)
        val loButton = findViewById<Button>(R.id.lowerButton)

        playingDeck = StandardDeck()
        playingDeck.initDeck()
        playingDeck.shuffleDeck()

        scoreTextView.text = score.toString()
        triesLeftTextView.text = triesLeft.toString()

        card1.text = playingDeck.drawCard().cardName

        hiButton.setOnClickListener {
            card2.text = playingDeck.drawCard().cardName
            checkCards(playingDeck.discardedCards[playingDeck.discardedCards.size-1],
                playingDeck.discardedCards[playingDeck.discardedCards.size-2])

        }

        loButton.setOnClickListener {
            card2.text = playingDeck.drawCard().cardName
            checkCards(playingDeck.discardedCards[playingDeck.discardedCards.size-2],
                playingDeck.discardedCards[playingDeck.discardedCards.size-1])
        }

    }

    private fun checkCards(hiCard: Card, loCard: Card)  {
        if (hiCard.valueInt > loCard.valueInt) {
            message.text = "Correct!"
            score++
        } else {
            message.text = "Wrong!"
            triesLeft--
        }
        scoreTextView.text = score.toString()
        triesLeftTextView.text = triesLeft.toString()
        if(triesLeft == 0) {
            gameOver()
        }
        return
    }

    private fun gameOver() {
        message.text = "Game Over"
    }
}