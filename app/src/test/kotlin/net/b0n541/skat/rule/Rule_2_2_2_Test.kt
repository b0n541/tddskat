package net.b0n541.skat.rule

import net.b0n541.skat.Card
import net.b0n541.skat.Hand
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test


/**
 * Rule 2.2.2
 *
 * The highest trumps of a Suit game are the Jacks in the ranking order of the colors.
 * They are followed by the seven cards of the trump suit according to the count of their points,
 * and in case of a tie, by the face value of the card.
 */
class Rule_2_2_2_Test {

    companion object {
        private const val CLUBS_CARDS = "C7 C8 C9 CT CQ CK CA DJ HJ SJ CJ"
        private const val SPADES_CARDS = "S7 S8 S9 ST SQ SK SA DJ HJ SJ CJ"
        private const val HEARTS_CARDS = "H7 H8 H9 HT HQ HK HA DJ HJ SJ CJ"
        private const val DIAMONDS_CARD = "D7 D8 D9 DT DQ DK DA DJ HJ SJ CJ"
    }

    @ParameterizedTest
    @ValueSource(strings = [CLUBS_CARDS, SPADES_CARDS, HEARTS_CARDS, DIAMONDS_CARD])
    fun `The highest trumps of a Suit game are the Jacks in the ranking order of the colors`(cards: String) {
        assertThat(Hand(cards).sorted())
            .startsWith(Card.CJ, Card.SJ, Card.HJ, Card.DJ)
    }

    @Test
    fun `They are followed by the seven cards of the trump suit`() {
        assertThat(Hand(CLUBS_CARDS).sorted())
            .containsExactly(
                Card.CJ,
                Card.SJ,
                Card.HJ,
                Card.DJ,
                Card.CA,
                Card.CT,
                Card.CK,
                Card.CQ,
                Card.C9,
                Card.C8,
                Card.C7
            )
        assertThat(Hand(SPADES_CARDS).sorted())
            .containsExactly(
                Card.CJ,
                Card.SJ,
                Card.HJ,
                Card.DJ,
                Card.SA,
                Card.ST,
                Card.SK,
                Card.SQ,
                Card.S9,
                Card.S8,
                Card.S7
            )
        assertThat(Hand(HEARTS_CARDS).sorted())
            .containsExactly(
                Card.CJ,
                Card.SJ,
                Card.HJ,
                Card.DJ,
                Card.HA,
                Card.HT,
                Card.HK,
                Card.HQ,
                Card.H9,
                Card.H8,
                Card.H7
            )
        assertThat(Hand(DIAMONDS_CARD).sorted())
            .containsExactly(
                Card.CJ,
                Card.SJ,
                Card.HJ,
                Card.DJ,
                Card.DA,
                Card.DT,
                Card.DK,
                Card.DQ,
                Card.D9,
                Card.D8,
                Card.D7
            )
    }
}
