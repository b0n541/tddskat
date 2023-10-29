package net.b0n541.skat

class CardDeck {
    private val cards = Card.entries.toList()

    /**
     * Size of the card deck.
     *
     * @return Size
     */
    val size = cards.size

    /**
     * Cards with a given suit.
     *
     * @param suit Suit
     * @return List of cards with the suit
     */
    fun cardsOfSuit(suit: Suit) = cards.filter { it.suit == suit }.toList()
}