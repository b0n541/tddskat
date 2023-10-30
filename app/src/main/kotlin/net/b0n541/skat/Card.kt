package net.b0n541.skat

/**
 * Card.
 *
 * @param suit Suit
 * @param rank Rank
 */
enum class Card(val suit: Suit, val rank: Rank) {
    CA(Suit.CLUBS, Rank.ACE),
    CK(Suit.CLUBS, Rank.KING),
    CQ(Suit.CLUBS, Rank.QUEEN),
    CJ(Suit.CLUBS, Rank.JACK),
    CT(Suit.CLUBS, Rank.TEN),
    C9(Suit.CLUBS, Rank.NINE),
    C8(Suit.CLUBS, Rank.EIGHT),
    C7(Suit.CLUBS, Rank.SEVEN),
    SA(Suit.SPADES, Rank.ACE),
    SK(Suit.SPADES, Rank.KING),
    SQ(Suit.SPADES, Rank.QUEEN),
    SJ(Suit.SPADES, Rank.JACK),
    ST(Suit.SPADES, Rank.TEN),
    S9(Suit.SPADES, Rank.NINE),
    S8(Suit.SPADES, Rank.EIGHT),
    S7(Suit.SPADES, Rank.SEVEN),
    HA(Suit.HEARTS, Rank.ACE),
    HK(Suit.HEARTS, Rank.KING),
    HQ(Suit.HEARTS, Rank.QUEEN),
    HJ(Suit.HEARTS, Rank.JACK),
    HT(Suit.HEARTS, Rank.TEN),
    H9(Suit.HEARTS, Rank.NINE),
    H8(Suit.HEARTS, Rank.EIGHT),
    H7(Suit.HEARTS, Rank.SEVEN),
    DA(Suit.DIAMONDS, Rank.ACE),
    DK(Suit.DIAMONDS, Rank.KING),
    DQ(Suit.DIAMONDS, Rank.QUEEN),
    DJ(Suit.DIAMONDS, Rank.JACK),
    DT(Suit.DIAMONDS, Rank.TEN),
    D9(Suit.DIAMONDS, Rank.NINE),
    D8(Suit.DIAMONDS, Rank.EIGHT),
    D7(Suit.DIAMONDS, Rank.SEVEN);
}

/**
 * Suit of a card.
 */
enum class Suit(val order: Int) {
    CLUBS(1),
    SPADES(2),
    HEARTS(3),
    DIAMONDS(4);
}

/**
 * Rank of a card.
 *
 * @param value Rank value
 */
enum class Rank(val value: Int = 0, val suitGameOrder: Int) {
    ACE(11, 2),
    TEN(10, 3),
    KING(4, 4),
    QUEEN(3, 5),
    JACK(2, 1),
    NINE(suitGameOrder = 6),
    EIGHT(suitGameOrder = 7),
    SEVEN(suitGameOrder = 8);
}