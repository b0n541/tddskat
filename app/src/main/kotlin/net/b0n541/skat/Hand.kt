package net.b0n541.skat

class Hand {
    private val cards: MutableSet<Card> = mutableSetOf()

    constructor(cardString: String) {
        cards.addAll(cardString.split(" ").map { Card.valueOf(it) })
    }

    fun sorted() = cards.toList()
        .sortedWith(compareBy<Card> { it.rank.suitGameOrder }.thenBy { it.suit.order })
}
