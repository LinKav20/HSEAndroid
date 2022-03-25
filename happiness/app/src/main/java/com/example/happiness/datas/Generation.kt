package com.example.happiness.datas

import kotlin.random.Random.Default.nextInt

class Generation {
    val texts: List<String> = listOf(
        "Самые лучшие праздники – те, что происходят внутри нас.",
        "Нет большего счастья, чем чувствовать, что люди любят тебя и радуются твоему присутствию.",
        "Счастливые сердца могут быть покорены, но они никогда не должны быть разбиты.",
        "Ты не найдешь такого, как он. Ты найдешь того, кто сделает тебя счастливой.",
        "Не прилагай столько усилий, всё самое лучшее случается неожиданно.",
        "Для счастья нужно что-то делать, что-то любить и во что-то верить.",
        "Счастье не в том, чтобы делать всегда, что хочешь, а в том, чтобы всегда хотеть того, что делаешь.",
        "Некоторым для счастья недостает только счастья.",
        "Мы не имеем права потреблять счастье, не производя его."
    );

    fun getText(): String {
        return texts[nextInt(0, texts.size)]
    }
}