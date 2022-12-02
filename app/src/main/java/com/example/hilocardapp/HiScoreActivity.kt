package com.example.hilocardapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/*
This activity shows the hi-scores. Uses sharedPreferences to read saved scores.
Uses HiScoreRecyclerAdapter to handle the RecyclerView.
 */
class HiScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_score)

        val sharedPreferences = getSharedPreferences("HiScores", Context.MODE_PRIVATE)
        val hiScores = mutableListOf<HiScoreItem>()

        //Reads the hi-scores...
        getHighScores(sharedPreferences, hiScores)
        //...and sorts them.
        hiScores.sortByDescending { it.score }

        val recyclerView = findViewById<RecyclerView>(R.id.hiScoreRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Lets the Adapter handle the scores.
        val adapter = HiScoreRecyclerAdapter(this, hiScores)
        recyclerView.adapter = adapter

        val menuButton = findViewById<Button>(R.id.menuButton2)

        //Get back to menu.
        menuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    /*
    Reads the sharedPreferences items to a mutable list.
     */
    private fun getHighScores(sharedPreferences : SharedPreferences, hiScores: MutableList<HiScoreItem>) {
        val hiScoreMap = sharedPreferences.all
        for(item in hiScoreMap) {

            val score = item.value
            hiScores.add(HiScoreItem(score as Int))
        }
    }

}




