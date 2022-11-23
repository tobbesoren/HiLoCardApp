package com.example.hilocardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule

class GameActivity : AppCompatActivity() {

    lateinit var playingDeck: StandardDeck

    lateinit var card1TextView : TextView
    lateinit var card2TextView : TextView
    lateinit var scoreTextView : TextView
    lateinit var triesLeftTextView : TextView
    lateinit var message : TextView
    lateinit var card1imageView : ImageView
    lateinit var card2imageView : ImageView

    var score = 0
    var triesLeft = 10


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //Initialize Views
        scoreTextView = findViewById(R.id.scoreTextView)
        triesLeftTextView = findViewById(R.id.triesLeftTextView)
        message = findViewById(R.id.messageTextView)

        card1TextView = findViewById(R.id.card1TextView)
        card2TextView = findViewById(R.id.card2TextView)

        card1imageView = findViewById(R.id.card1ImageView)
        card2imageView = findViewById(R.id.card2ImageView)

//        val hiButton = findViewById<Button>(R.id.higherButton)
//        val loButton = findViewById<Button>(R.id.lowerButton)

        //Initialize playingDeck
        playingDeck = StandardDeck()
        playingDeck.initDeck()

        startGame()


        /*hiButton.setOnClickListener {
            card2TextView.text = playingDeck.drawCard().cardName
            card2imageView.setImageResource(playingDeck.discardedCards.last().pictureID)
            checkCards(playingDeck.discardedCards[playingDeck.discardedCards.size-1],
                playingDeck.discardedCards[playingDeck.discardedCards.size-2])

            delay()

        }

        loButton.setOnClickListener {
            card2TextView.text = playingDeck.drawCard().cardName
            card2imageView.setImageResource(playingDeck.discardedCards.last().pictureID)
            checkCards(playingDeck.discardedCards[playingDeck.discardedCards.size-2],
                playingDeck.discardedCards[playingDeck.discardedCards.size-1])

            delay()

        }*/

    }

    fun startGame() {
        addPlayFragment()
        playingDeck.shuffleDeck()

        scoreTextView.text = "Score: $score"
        triesLeftTextView.text = "Tries left: $triesLeft"

        card1TextView.text = playingDeck.drawCard().cardName
        card2TextView.text = "--"

        //message.text = "Make your guess"

        card1imageView.setImageResource(playingDeck.discardedCards[0].pictureID)
    }

    fun checkCards(hiCard: Card, loCard: Card)  {
        if (hiCard.valueInt > loCard.valueInt) {
            message.text = "Correct!"
            score++
        } else {
            message.text = "Wrong!"
            triesLeft--
        }
        scoreTextView.text = "Score: $score"
        triesLeftTextView.text = "Tries left: $triesLeft"
        if(triesLeft == 0) {
            gameOver()
        }
        return
    }

    private fun addPlayFragment() {
        val playFragment = PlayFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, playFragment, "playFragment")
        transaction.commit()
    }

    fun delay() {
        Timer("SettingUp", false).schedule(2500) {
            moveCardImage()
        }
    }

    fun moveCardImage() {
        card1imageView.setImageResource(playingDeck.discardedCards.last().pictureID)
        card2imageView.setImageResource(R.drawable.card_back)

    }

    fun gameOver() {
        message.text = "Game Over"
    }
}