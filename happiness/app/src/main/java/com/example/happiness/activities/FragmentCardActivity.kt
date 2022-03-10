package com.example.happiness.activities

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
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
    private var position = 0

    private val cards = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()

        initViews()
        loadCards()
        setContentToCard()
        setAnima()
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("NUMBER OF THE CARD")?.let {
            position = it
        }
    }

    fun loadCards() {
        for (i in 1..40) {
            val card = Card()
            card.back_text = Card.words[i - 1]
            card.front_text = "Сюда можно нажать"
            card.back_image =
                getResources().getIdentifier("p$i", "drawable", context?.getPackageName())
            card.front_image = R.drawable.planet_love_card
            cards.add(card)
        }
    }

    fun initViews() {
        frontAnim =
            AnimatorInflater.loadAnimator(activity, R.animator.front_flip) as AnimatorSet
        backAnim =
            AnimatorInflater.loadAnimator(activity, R.animator.back_flip) as AnimatorSet

        cardViewFront = view?.findViewById(R.id.cardViewFront) as CardView
        cardViewBack = view?.findViewById(R.id.cardViewBack) as CardView

        frontCardText = view?.findViewById(R.id.textViewMemoryFront) as TextView
        backCardText = view?.findViewById(R.id.textViewMemoryBack) as TextView
    }

    fun setContentToCard() {
        if (position != -1) {
            frontCardText.setBackgroundResource(cards[position].front_image)
            backCardText.setBackgroundResource(cards[position].back_image)
            frontCardText.text = cards[position].front_text
            backCardText.text = cards[position].back_text
            frontCardText.gravity = Gravity.CENTER
            backCardText.gravity = Gravity.CENTER
        } else {
            frontCardText.setBackgroundResource(R.drawable.planet_love_card)
            backCardText.setBackgroundResource(R.drawable.not_a_time)
            frontCardText.text = "Сюда можно нажать"
            backCardText.text = "Время еще не пришло"
            frontCardText.gravity = Gravity.CENTER
            backCardText.gravity = Gravity.CENTER
        }
    }

    fun setAnima() {
        val scale = context?.applicationContext?.resources?.displayMetrics?.density

        cardViewFront.cameraDistance = 8000 * scale!!
        cardViewBack.cameraDistance = 8000 * scale!!

        cardViewFront.setOnClickListener {
            flipTheCard()
        }
    }

    companion object {

        fun newInstance(position: Int): FragmentCardActivity {
            val args = Bundle()
            args.putInt("NUMBER OF THE CARD", position)
            val fragment = FragmentCardActivity()
            fragment.arguments = args
            return fragment
        }

    }
}