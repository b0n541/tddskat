package org.b0n541.tddskat.rule

import org.assertj.core.api.Assertions.assertThat
import org.b0n541.tddskat.Card
import org.b0n541.tddskat.Deck
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class DeckTest {

    val deck = Deck()

    @Test
    fun `Rule 1 2 1 - Deck consists of 32 cards`() {
        assertThat(deck.cards).hasSize(32)
    }

    @Test
    fun `Rule 1 2 1 - Deck consists of four suits`() {
        assertThat(
                deck.cards.stream()
                        .map { card -> card.suit }
                        .distinct())
                .hasSize(4)
    }

    @Test
    fun `Rule 1 2 1 - Suits are ranked high to low in the order CLUBS, SPADES, HEARTS to DIAMONDS`() {
        assertThat(
                deck.cards.stream()
                        .map { card -> card.suit }
                        .distinct()
                        .sorted())
                .containsExactly(
                        Card.Suit.CLUBS,
                        Card.Suit.SPADES,
                        Card.Suit.HEARTS,
                        Card.Suit.DIAMONDS)
    }

    @ParameterizedTest
    @MethodSource("cardValues")
    fun `Cards in each suit have the following values`(data: CardValue) {
        assertThat(data.card.rank.value).isEqualTo(data.expectedValue)
    }

    private fun cardValues() = Stream.of(
            CardValue(Card.CA, 11),
            CardValue(Card.CT, 10),
            CardValue(Card.CK, 4),
            CardValue(Card.CQ, 3),
            CardValue(Card.CJ, 2),
            CardValue(Card.C9, 0),
            CardValue(Card.C8, 0),
            CardValue(Card.C7, 0)
    )

    data class CardValue(val card: Card, val expectedValue: Int)
}