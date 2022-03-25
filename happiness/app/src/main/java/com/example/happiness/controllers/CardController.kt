package com.example.happiness.controllers

import com.example.happiness.models.Card

class CardController() {
    private val cards = arrayListOf<Card>()

    init {
        addCardInTheEnd(Card("ABOUT", "Created by Maltseva Angelina 206"))
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