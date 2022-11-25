package com.example.hilocardapp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GameOverFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameOverFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_game_over, container, false)

        val hiScoresButton = view.findViewById<Button>(R.id.hiScoresButton)
        val menuButton = view.findViewById<Button>(R.id.menuButton)

        val gameActivity = activity as GameActivity

        addHiScore(gameActivity)



        hiScoresButton.setOnClickListener {
            val intent = Intent(gameActivity, HiScoreActivity::class.java)
            startActivity(intent)
            gameActivity.finish()
        }

        menuButton.setOnClickListener {
            with(gameActivity) {
                returnToMainMenu()
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment GameOverFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameOverFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun addHiScore(gameActivity: GameActivity) {
        val sharedPreferences = gameActivity.getSharedPreferences("HiScores", Context.MODE_PRIVATE)

        val nextKey = (sharedPreferences.all.size + 1).toString()
        sharedPreferences.edit().putInt("$nextKey", gameActivity.score).commit()
        val item = sharedPreferences.getInt("Name", Context.MODE_PRIVATE)
        Log.d("!!!!", "$item")
    }
}