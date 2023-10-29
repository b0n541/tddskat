package net.b0n541.skat

class CardDeck {
    private val cards = Card.entries.toList()

    val size = cards.size
    fun cardsOfSuit(suit: Suit) = cards.filter { it.suit == suit }.toList()
}