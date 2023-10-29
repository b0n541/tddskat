package net.b0n541.skat

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import kotlin.test.Test


/**
 * Rule 2.1.1
 *
 * There are two game classes: games with Skat pick up and games without Skat pick up (hand games).
 * In both game classes there are three types of games: Suit games, Grand games and Null games.
 */
class Rule_2_1_1_Test {

    private lateinit var game: SkatGame

    @BeforeEach
    fun setupGame() {
        game = SkatGame(SkatPlayer("One"), SkatPlayer("Two"), SkatPlayer("Three"))
    }

    @Test
    fun `There are two game classes - games with Skat pick up and games without Skat pick up (hand games)`() {
        assertThat(game.isHand()).isTrue()

        game.pickUpSkat()

        assertThat(game.isHand()).isFalse()
    }

    @ParameterizedTest
    @EnumSource(GameType::class)
    fun `In both game classes there are three types of games - Suit games, Grand games and Null games`(gameType: GameType) {
        assertThat(game.getGameType()).isNull()
        assertThat(game.isHand()).isTrue()

        game.announceGameContract(gameType, true)
        assertThat(game.getGameType()).isEqualTo(gameType)

        assertThatThrownBy { game.announceGameContract(gameType, false) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("Skat was not picked up. Game must be a hand game.")

        game.pickUpSkat()

        assertThat(game.isHand()).isFalse()

        game.announceGameContract(gameType, false)
        assertThat(game.getGameType()).isEqualTo(gameType)

        assertThatThrownBy { game.announceGameContract(gameType, true) }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("Skat was already picked up. No hand game possible anymore.")
    }
}
