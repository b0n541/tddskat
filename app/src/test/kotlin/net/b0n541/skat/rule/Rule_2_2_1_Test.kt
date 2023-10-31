package net.b0n541.skat.rule

import net.b0n541.skat.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource


/**
 * Rule 2.2.1
 *
 * In the Suit games, one color is always trumps.
 * The other colors are then equal in rank.
 */
class Rule_2_2_1_Test {

    private lateinit var game: SkatGame

    @BeforeEach
    fun setUp() {
        game = SkatGame(SkatPlayer("One"), SkatPlayer("Two"), SkatPlayer("Three"))
    }

    @ParameterizedTest
    @EnumSource(value = GameType::class)
    fun `In the Suit games, one color is always trumps`(gameType: GameType) {
        game.announceGameContract(gameType, true, false)

        if (setOf(GameType.CLUBS, GameType.SPADES, GameType.HEARTS, GameType.DIAMONDS).contains(gameType)) {
            val trumpSuit = Suit.valueOf(gameType.name)

            assertThat(game.getTrumpSuit()).isEqualTo(trumpSuit)

            assertThat(SuitRules.trumps(game, trumpSuit, trumpSuit)).isFalse()
            Suit.entries.minus(trumpSuit).forEach {
                assertThat(SuitRules.trumps(game, trumpSuit, it)).isTrue()
            }
        } else {
            assertThat(game.getTrumpSuit()).isNull()
        }
    }

    @ParameterizedTest
    @EnumSource(value = GameType::class, names = ["GRAND", "NULL"], mode = EnumSource.Mode.EXCLUDE)
    fun `The other colors are then equal in rank`(gameType: GameType) {
        game.announceGameContract(gameType, true, false)

        val trumpSuit = Suit.valueOf(gameType.name)

        assertThat(SuitRules.equal(game, trumpSuit, trumpSuit)).isTrue()

        Suit.entries.minus(trumpSuit).forEach { nonTrumpSuit ->
            Suit.entries.minus(setOf(trumpSuit, nonTrumpSuit)).forEach { otherNonTrumpSuit ->
                assertThat(SuitRules.equal(game, nonTrumpSuit, otherNonTrumpSuit)).isTrue()
            }
        }
    }
}
