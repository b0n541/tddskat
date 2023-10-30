package net.b0n541.skat.rule

import net.b0n541.skat.Card
import net.b0n541.skat.CardDeck
import net.b0n541.skat.Rank
import net.b0n541.skat.Suit
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * Rule 1.2.2
 *
 * Each suit has the following cards with the following count value:
 *
 * Ace     - 11 points
 * 10      - 10 points
 * King    - 4 points
 * Queen   - 3 points
 * Jack    - 2 points
 * 9, 8, 7 - 0 points
 *
 * The card deck therefore counts 120 points.
 */
class Rule_1_2_2_Test {

    private val cardDeck = CardDeck()

    @Test
    fun `Each suit has the following cards - Ace 10 King Queen Jack 9 8 7`() {
        assertRanksOf(cardDeck.cardsOfSuit(Suit.CLUBS))
        assertRanksOf(cardDeck.cardsOfSuit(Suit.SPADES))
        assertRanksOf(cardDeck.cardsOfSuit(Suit.HEARTS))
        assertRanksOf(cardDeck.cardsOfSuit(Suit.DIAMONDS))
    }

    private fun assertRanksOf(cards: List<Card>) {
        assertThat(cards.map { it.rank })
            .containsExactlyInAnyOrder(
                Rank.ACE,
                Rank.KING,
                Rank.QUEEN,
                Rank.JACK,
                Rank.TEN,
                Rank.NINE,
                Rank.EIGHT,
                Rank.SEVEN
            )
    }

    @Test
    fun `Each suit has the following following count values - 11 10 4 3 2 0 0 0`() {
        assertThat(Rank.ACE.value).isEqualTo(11)
        assertThat(Rank.TEN.value).isEqualTo(10)
        assertThat(Rank.KING.value).isEqualTo(4)
        assertThat(Rank.QUEEN.value).isEqualTo(3)
        assertThat(Rank.JACK.value).isEqualTo(2)
        assertThat(Rank.NINE.value).isEqualTo(0)
        assertThat(Rank.EIGHT.value).isEqualTo(0)
        assertThat(Rank.SEVEN.value).isEqualTo(0)
    }
}
