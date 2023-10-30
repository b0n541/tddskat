package net.b0n541.skat.rule

import net.b0n541.skat.CardDeck
import net.b0n541.skat.Suit
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * Rule 1.2.1
 *
 * The Skat card consists of 32 single cards in four suits of eight cards each.
 * The suits in their order are clubs (acorns), spades (green), hearts (red) and (red) and diamonds (bells).
 */
class Rule_1_2_1_Test {

    private val cardDeck = CardDeck()

    @Test
    fun `The Skat card consists of 32 single cards in four suits of eight cards each`() {
        assertThat(cardDeck.size).isEqualTo(32)
        assertThat(cardDeck.cardsOfSuit(Suit.CLUBS).size).isEqualTo(8)
        assertThat(cardDeck.cardsOfSuit(Suit.SPADES).size).isEqualTo(8)
        assertThat(cardDeck.cardsOfSuit(Suit.HEARTS).size).isEqualTo(8)
        assertThat(cardDeck.cardsOfSuit(Suit.DIAMONDS).size).isEqualTo(8)
    }

    @Test
    fun `The suits in their order are clubs (acorns), spades (green), hearts (red) and (red) and diamonds (bells)`() {
        assertThat(listOf(Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES, Suit.CLUBS).sorted())
            .containsExactly(Suit.CLUBS, Suit.SPADES, Suit.HEARTS, Suit.DIAMONDS)
    }
}
