package net.b0n541.skat

/**
 * Card
 *
 * @param suit Suit
 */
enum class Card(val suit: Suit) {
    CA(Suit.CLUBS),
    CK(Suit.CLUBS),
    CQ(Suit.CLUBS),
    CJ(Suit.CLUBS),
    CT(Suit.CLUBS),
    C9(Suit.CLUBS),
    C8(Suit.CLUBS),
    C7(Suit.CLUBS),
    SA(Suit.SPADES),
    SK(Suit.SPADES),
    SQ(Suit.SPADES),
    SJ(Suit.SPADES),
    ST(Suit.SPADES),
    S9(Suit.SPADES),
    S8(Suit.SPADES),
    S7(Suit.SPADES),
    HA(Suit.HEARTS),
    HK(Suit.HEARTS),
    HQ(Suit.HEARTS),
    HJ(Suit.HEARTS),
    HT(Suit.HEARTS),
    H9(Suit.HEARTS),
    H8(Suit.HEARTS),
    H7(Suit.HEARTS),
    DA(Suit.DIAMONDS),
    DK(Suit.DIAMONDS),
    DQ(Suit.DIAMONDS),
    DJ(Suit.DIAMONDS),
    DT(Suit.DIAMONDS),
    D9(Suit.DIAMONDS),
    D8(Suit.DIAMONDS),
    D7(Suit.DIAMONDS)
}

enum class Suit {
    CLUBS,
    SPADES,
    HEARTS,
    DIAMONDS
}