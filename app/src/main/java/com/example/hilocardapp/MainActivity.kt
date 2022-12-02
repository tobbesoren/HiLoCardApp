package com.example.hilocardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/*
Look up shared preferences!
 */


class MainActivity : AppCompatActivity() {

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
    }

    private fun startGame() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun viewHighScore() {
        val intent = Intent(this, HiScoreActivity::class.java)
        startActivity(intent)
        finish()
    }

}