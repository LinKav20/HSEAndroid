package com.example.happiness

import com.example.happiness.models.Card

class CardController() {
    private val cards = arrayListOf<Card>()

    init {
        addCardInTheEnd(Card("SETTINGS", "Notifications"))
    }

    fun addCardInTheEnd(card: Card) {
        cards.add(card)
    }

    fun addCardByIndex(card: Card, index: Int) {
        cards.add(index, card)
    }

    fun getCount(): Int {
        return cards.size
    }

    operator fun get(position: Int): Card {
        return cards[position]
    }
}