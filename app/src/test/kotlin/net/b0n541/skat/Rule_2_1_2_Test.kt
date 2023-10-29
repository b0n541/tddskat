package net.b0n541.skat

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource


/**
 * Rule 2.1.2
 *
 * The possible games are divided as follows
 *
 * +-------------+------------------------+----------------------------------+
 * | Game type   | Game with Skat pick up | Hand game                        |
 * +-------------+------------------------+----------------------------------+
 * | Suit games  | Diamonds               | Diamonds hand | Diamonds ouvert  |
 * |             | Hearts                 | Hearts hand   | Hearts ouvert    |
 * |             | Spades                 | Spades hand   | Spades ouvert    |
 * |             | Clubs                  | Clubs hand    | Clubs ouvert     |
 * +-------------+------------------------+---------------+------------------+
 * | Grand games | Grand                  | Grand hand    | Grand ouvert     |
 * +-------------+---------+--------------+---------------+------------------+
 * | Null games  | Null    | Null ouvert  | Null hand     | Null hand ouvert |
 * +-------------+---------+--------------+---------------+------------------+
 */
class Rule_2_1_2_Test {

    private lateinit var game: SkatGame

    @BeforeEach
    fun setupGame() {
        game = SkatGame(SkatPlayer("One"), SkatPlayer("Two"), SkatPlayer("Three"))
    }

    @ParameterizedTest
    @EnumSource(GameType::class)
    fun `Game with Skat pick up`(gameType: GameType) {
        game.pickUpSkat()
        game.announceGameContract(gameType, false, false)

        assertThat(game.getGameType()).isEqualTo(gameType)
        assertThat(game.isHand()).isFalse()
        assertThat(game.isOuvert()).isFalse()

        if (GameType.NULL == gameType) {
            game.announceGameContract(gameType, false, true)

            assertThat(game.getGameType()).isEqualTo(gameType)
            assertThat(game.isHand()).isFalse()
            assertThat(game.isOuvert()).isTrue()
        } else {
            assertThatThrownBy { game.announceGameContract(gameType, false, true) }
                .isInstanceOf(IllegalStateException::class.java)
                .hasMessage("Ouvert is only allowed in hand games.")
        }
    }

    @ParameterizedTest
    @EnumSource(GameType::class)
    fun `Game without Skat pick up`(gameType: GameType) {
        game.announceGameContract(gameType, true, false)

        assertThat(game.getGameType()).isEqualTo(gameType)
        assertThat(game.isHand()).isTrue()
        assertThat(game.isOuvert()).isFalse()

        game.announceGameContract(gameType, true, true)

        assertThat(game.getGameType()).isEqualTo(gameType)
        assertThat(game.isHand()).isTrue()
        assertThat(game.isOuvert()).isTrue()
    }
}
