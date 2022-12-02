package com.example.hilocardapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import kotlin.concurrent.schedule

class GameActivity : AppCompatActivity() {

    /*
    Declaring common variables:
     */

    //First, the Deck...
    lateinit var playingDeck: Deck

    //...then, the Activity's Views...
    private lateinit var scoreTextView : TextView
    lateinit var triesLeftTextView : TextView
    lateinit var message : TextView
    lateinit var card1imageView : ImageView
    lateinit var card2imageView : ImageView
    lateinit var oldCard : Card
    lateinit var newCard : Card


    ///...the Fragments...
    val mainPlayFragment = PlayFragment()
    private val mainResultFragment = ResultFragment()
    private val mainGameOverFragment = GameOverFragment()


    //...and the score; and triesLeft.
    var score = 0
    var triesLeft = 5



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        //Initialize Views
        scoreTextView = findViewById(R.id.scoreTextView)
        triesLeftTextView = findViewById(R.id.triesLeftTextView)
        message = findViewById(R.id.messageTextView)
        card1imageView = findViewById(R.id.card1ImageView)
        card2imageView = findViewById(R.id.card2ImageView)

        //Initialize playingDeck
        playingDeck = Deck()
        playingDeck.initDeck()

        //Let's play!
        startGame()
    }

    /*
    Sets up the initial playfield.
     */
    private fun startGame() {
        replaceWithPlayFragment()
        playingDeck.shuffleDeck()

        oldCard = playingDeck.drawCard()

        scoreTextView.text = "Score: $score"
        triesLeftTextView.text = "Tries left: $triesLeft"

        message.text = "Make your guess"

        card1imageView.setImageResource(playingDeck.discardedCards[0].pictureID)
        card2imageView.setImageResource(R.drawable.card_back)
    }

    /*
    Used to check if the player's guess is correct.
    Takes two Cards as arguments: The one the player thinks is the highest, and
    the one the player thinks is the lowest. Updates score, triesLeft and the
    corresponding textViews accordingly, and calls gameOver() if needed.
     */
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

    /*
    Used to change the bottom field in GameActivity to the PlayFragment,
    which holds the LOWER and HIGHER buttons.
     */
    private fun replaceWithPlayFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, mainPlayFragment, "playFragment")
        transaction.commit()
    }

    /*
    Used to change the bottom field in GameActivity to the ResultFragment,
    which holds the CONTINUE button.
     */
    fun replaceWithResultFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, mainResultFragment, "resultFragment")
        transaction.commit()
    }

    /*
    Used to change the bottom field in GameActivity to the GameOverFragment,
    which holds the HI-SCORES and MENU buttons.
     */
    private fun replaceWithGameOverFragment() {
        Log.d("!!!!", "game over")
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, mainGameOverFragment, "gameOverFragment")
        transaction.commit()
    }

    /*
    Used to return to the MainActivity, which holds the main menu. Finishes the GameActivity.
     */
    fun returnToMainMenu() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    /*
    Used to move the card from the right to the left, to set up the next guess.
     */
    fun moveCardImage() {
        card1imageView.setImageResource(oldCard.pictureID)
        card2imageView.setImageResource(R.drawable.card_back)
    }

    /*
    Runs when there are no tries left.
     */
    private fun gameOver() {
        message.text = "Game Over"
        replaceWithGameOverFragment()
    }
}