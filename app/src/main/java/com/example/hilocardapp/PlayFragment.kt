package com.example.hilocardapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/*
Used for the play field.
 */

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PlayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlayFragment : Fragment() {
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


        val view = inflater.inflate(R.layout.fragment_play, container, false)
        val hiButton = view.findViewById<Button>(R.id.higherButton)
        val loButton = view.findViewById<Button>(R.id.lowerButton)

        val gameActivity = activity as GameActivity
        val mainDeckTextView = gameActivity.findViewById<TextView>(R.id.deckTextView)

        hiButton.setOnClickListener {
            nextCard()
            with(gameActivity) {
                mainDeckTextView.text = "Cards left: ${playingDeck.mainDeck.size}"
                checkCards(newCard, oldCard)
                replaceWithResultFragment()
            }
        }

        loButton.setOnClickListener {
            nextCard()
            with(gameActivity) {
                mainDeckTextView.text = "Cards left: ${playingDeck.mainDeck.size}"
                checkCards(oldCard, newCard)
                replaceWithResultFragment()
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
         * @return A new instance of fragment PlayFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PlayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    fun nextCard() {
        val gameActivity = activity as GameActivity
        with(gameActivity) {
            newCard = playingDeck.drawCard()
            card2TextView.text = newCard.cardName
            card2imageView.setImageResource(newCard.pictureID)
        }
    }
}