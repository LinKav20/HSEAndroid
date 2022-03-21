package com.example.happiness.activities

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.happiness.R
import com.example.happiness.models.Card

class FragmentCardActivity : Fragment() {

    private lateinit var cardViewFront: CardView
    private lateinit var cardViewBack: CardView

    private lateinit var frontAnim: AnimatorSet
    private lateinit var backAnim: AnimatorSet

    private lateinit var frontCardText: TextView
    private lateinit var backCardText: TextView

    private var isFront = true
    private lateinit var frontText: String
    private lateinit var backText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        loadAll()
        animationSettings()

        frontCardText.text = frontText
        backCardText.text = backText

        cardViewFront.setOnClickListener {
            flipTheCard()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    private fun flipTheCard() {
        if (isFront) {
            flipFront()
        } else {
            flipBack()
        }
    }

    private fun flipFront() {
        frontAnim.setTarget(cardViewFront)
        backAnim.setTarget(cardViewBack)
        frontAnim.start()
        backAnim.start()
        isFront = false
    }

    private fun flipBack() {
        frontAnim.setTarget(cardViewBack)
        backAnim.setTarget(cardViewFront)
        frontAnim.start()
        backAnim.start()
        isFront = true
    }

    private fun animationSettings() {
        val scale = context?.applicationContext?.resources?.displayMetrics?.density

        cardViewFront.cameraDistance = 8000 * scale!!
        cardViewBack.cameraDistance = 8000 * scale!!
    }

    private fun loadAll() {
        frontAnim =
            AnimatorInflater.loadAnimator(activity, R.animator.front_flip) as AnimatorSet
        backAnim =
            AnimatorInflater.loadAnimator(activity, R.animator.back_flip) as AnimatorSet

        cardViewFront = view?.findViewById(R.id.cardViewFront) as CardView
        cardViewBack = view?.findViewById(R.id.cardViewBack) as CardView

        frontCardText = view?.findViewById(R.id.textViewMemoryFront) as TextView
        backCardText = view?.findViewById(R.id.textViewMemoryBack) as TextView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getString("FRONT TEXT")?.let {
            frontText = it
        }
        arguments?.getString("BACK TEXT")?.let {
            backText = it
        }
    }

    companion object {

        fun newInstance(card: Card): FragmentCardActivity {
            val args = Bundle()

            args.putString("FRONT TEXT", card.front_text)
            args.putString("BACK TEXT", card.back_text)

            val fragment = FragmentCardActivity()
            fragment.arguments = args
            return fragment
        }

    }
}
