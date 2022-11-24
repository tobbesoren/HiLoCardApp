package com.example.hilocardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    lateinit var oldCard : Card
    lateinit var newCard : Card

    val mainPlayFragment = PlayFragment()
    val mainResultFragment = ResultFragment()
    val mainGameOverFragment = GameOverFragment()

    var score = 0
    var triesLeft = 1


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


    }

    fun startGame() {
        replaceWithPlayFragment()
        playingDeck.shuffleDeck()

        oldCard = playingDeck.drawCard()

        scoreTextView.text = "Score: $score"
        triesLeftTextView.text = "Tries left: $triesLeft"

        card1TextView.text = oldCard.cardName
        card2TextView.text = "--"

        message.text = "Make your guess"

        card1imageView.setImageResource(playingDeck.discardedCards[0].pictureID)
        card2imageView.setImageResource(R.drawable.card_back)
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

    fun replaceWithPlayFragment() {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, mainPlayFragment, "playFragment")
        transaction.commit()
    }

    fun replaceWithResultFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, mainResultFragment, "resultFragment")
        transaction.commit()
    }

    fun addGameOverFragment() {
        Log.d("!!!!", "game over")
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, mainGameOverFragment, "gameOverFragment")
        transaction.commit()
    }

    fun returnToMainMenu() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
    }

    fun delay() {
        Timer("SettingUp", false).schedule(2500) {
            moveCardImage()
        }
    }

    fun moveCardImage() {
        card1imageView.setImageResource(oldCard.pictureID)
        card2imageView.setImageResource(R.drawable.card_back)
        card1TextView.text = oldCard.cardName
        card2TextView.text = "--"

    }

    fun gameOver() {
        message.text = "Game Over"
        addGameOverFragment()
    }
}