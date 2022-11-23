package com.example.hilocardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

/*
Look up shared preferences!
 */


class MainActivity : AppCompatActivity() {

    var highScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            startGame()
        }

        val highScoreButton = findViewById<Button>(R.id.highScoreButton)
        highScoreButton.setOnClickListener {
            viewHighScore()
        }

        val testButton = findViewById<Button>(R.id.testButton)
        testButton.setOnClickListener {
            testDeck()
        }


    }

    private fun startGame() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun viewHighScore() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun testDeck() {
        val intent = Intent(this, TestActivity::class.java)
        startActivity(intent)
    }

}