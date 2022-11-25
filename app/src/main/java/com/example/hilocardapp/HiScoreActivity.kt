package com.example.hilocardapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HiScoreActivity : AppCompatActivity() {

    val hiScores = mutableListOf<HiScoreItem>()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hi_score)

        createTestData()

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

    fun createTestData() {
        for(i in 1..25) {
            hiScores.add(HiScoreItem((1..35).shuffled()[0], "Tobbe"))
        }
        hiScores.sortBy{it.score}
    }
}