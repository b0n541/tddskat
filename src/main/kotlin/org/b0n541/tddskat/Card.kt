package org.b0n541.tddskat

enum class Card(val suit: Suit, val rank: Rank) {

    CA(Suit.CLUBS, Rank.ACE),
    CT(Suit.CLUBS, Rank.TEN),
    CK(Suit.CLUBS, Rank.KING),
    CQ(Suit.CLUBS, Rank.QUEEN),
    CJ(Suit.CLUBS, Rank.JACK),
    C9(Suit.CLUBS, Rank.NINE),
    C8(Suit.CLUBS, Rank.EIGHT),
    C7(Suit.CLUBS, Rank.SEVEN),
    SA(Suit.SPADES, Rank.ACE),
    ST(Suit.SPADES, Rank.TEN),
    SK(Suit.SPADES, Rank.KING),
    SQ(Suit.SPADES, Rank.QUEEN),
    SJ(Suit.SPADES, Rank.JACK),
    S9(Suit.SPADES, Rank.NINE),
    S8(Suit.SPADES, Rank.EIGHT),
    S7(Suit.SPADES, Rank.SEVEN),
    HA(Suit.HEARTS, Rank.ACE),
    HT(Suit.HEARTS, Rank.TEN),
    HK(Suit.HEARTS, Rank.KING),
    HQ(Suit.HEARTS, Rank.QUEEN),
    HJ(Suit.HEARTS, Rank.JACK),
    H9(Suit.HEARTS, Rank.NINE),
    H8(Suit.HEARTS, Rank.EIGHT),
    H7(Suit.HEARTS, Rank.SEVEN),
    DA(Suit.DIAMONDS, Rank.ACE),
    DT(Suit.DIAMONDS, Rank.TEN),
    DK(Suit.DIAMONDS, Rank.KING),
    DQ(Suit.DIAMONDS, Rank.QUEEN),
    DJ(Suit.DIAMONDS, Rank.JACK),
    D9(Suit.DIAMONDS, Rank.NINE),
    D8(Suit.DIAMONDS, Rank.EIGHT),
    D7(Suit.DIAMONDS, Rank.SEVEN);

    enum class Suit {
        CLUBS,
        SPADES,
        HEARTS,
        DIAMONDS
    }

    enum class Rank(val value: Int = 0) {
        ACE(11),
        TEN(10),
        KING(4),
        QUEEN(3),
        JACK(2),
        NINE,
        EIGHT,
        SEVEN
    }
}