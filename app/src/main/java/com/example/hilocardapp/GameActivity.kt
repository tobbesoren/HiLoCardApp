package com.example.hilocardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {

    lateinit var playingDeck: StandardDeck

    lateinit var card1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        card1 = findViewById(R.id.card1TextView)

        playingDeck = StandardDeck()
        playingDeck.initDeck()
        playingDeck.shuffleDeck()


        card1.text = playingDeck.drawCard().cardName

        //card1.text = playingDeck.drawCard().cardName

    }
    // testing testing




}