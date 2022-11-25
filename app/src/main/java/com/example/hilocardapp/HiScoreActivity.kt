package com.example.hilocardapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.util.prefs.Preferences

class HiScoreActivity : AppCompatActivity() {






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_score)

        val sharedPreferences = getSharedPreferences("HiScores", Context.MODE_PRIVATE)
        val hiScores = mutableListOf<HiScoreItem>()


        //createTestData(hiScores)
        getHighScores(sharedPreferences, hiScores)
        hiScores.sortByDescending { it.score }

        val recyclerView = findViewById<RecyclerView>(R.id.hiScoreRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = HiScoreRecyclerAdapter(this, hiScores)
        recyclerView.adapter = adapter

        val menuButton = findViewById<Button>(R.id.menuButton2)

        menuButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun createTestData(hiScores: MutableList<HiScoreItem>) {
        for(i in 1..5) {
            hiScores.add(HiScoreItem((1..35).shuffled()[0], "Tobbe"))
        }

    }

    fun getHighScores(sharedPreferences : SharedPreferences, hiScores: MutableList<HiScoreItem>) {
        val hiScoreMap = sharedPreferences.all
        for(item in hiScoreMap) {
            Log.d("!!!!", "Hey")
            val name = item.key
            val score = item.value
            Log.d("!!!!", "$name, $score")
            hiScores.add(HiScoreItem(score as Int, name))
        }
    }


}