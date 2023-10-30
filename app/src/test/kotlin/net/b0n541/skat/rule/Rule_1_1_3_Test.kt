package net.b0n541.skat.rule

import net.b0n541.skat.Card
import net.b0n541.skat.SkatGame
import net.b0n541.skat.SkatPlayer
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * Rule 1.1.3
 *
 * Two cards laid face down, separately - called Skat gave the game its name.
 * It is  * Italian (scartare) and French (écarter), respectively, and meansFrench (écarter) and means as much as
 * "the laid away".
 */
class Rule_1_1_3_Test {
    @Test
    fun `Two cards laid face down, separately - called Skat gave the game its name`() {
        val game = SkatGame(SkatPlayer("One"), SkatPlayer("Two"), SkatPlayer("Three"))

        assertThat(game.skat).isEqualTo(Pair(Card.CJ, Card.SJ))
    }
}