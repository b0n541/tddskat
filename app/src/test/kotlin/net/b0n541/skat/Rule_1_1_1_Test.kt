package net.b0n541.skat

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import kotlin.test.Test

/**
 * Rule 1.1.1:
 *
 * The Skat game is a card game for three or more people.
 * The single game is played by one player and two opponents.
 */
class Rule_1_1_1_Test {

    private val PLAYER_ONE = SkatPlayer("Player One")
    private val PLAYER_TWO = SkatPlayer("Player Two")
    private val PLAYER_THREE = SkatPlayer("Player Three")
    private val PLAYER_FOUR = SkatPlayer("Player Four")

    private val TWO_PLAYER_TABLE = SkatTable(listOf(PLAYER_ONE, PLAYER_TWO))
    private val THREE_PLAYER_TABLE = SkatTable(listOf(PLAYER_ONE, PLAYER_TWO, PLAYER_THREE))
    private val FOUR_PLAYER_TABLE = SkatTable(listOf(PLAYER_ONE, PLAYER_TWO, PLAYER_THREE, PLAYER_FOUR))

    @Test
    fun `The Skat game is a card game for three or more people - two player`() {
        assertThat(TWO_PLAYER_TABLE.getPlayerCount()).isEqualTo(2)
        assertThat(TWO_PLAYER_TABLE.hasEnoughPlayers()).isFalse()

        assertThatThrownBy { TWO_PLAYER_TABLE.newGame() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessage("At least 3 players are needed to play a game of Skat. Currently only 2 player sit at the table.")
    }

    @Test
    fun `The Skat game is a card game for three or more people - three player`() {
        assertThat(THREE_PLAYER_TABLE.getPlayerCount()).isEqualTo(3)
        assertThat(THREE_PLAYER_TABLE.hasEnoughPlayers()).isTrue()
        assertGamePlayerNames(THREE_PLAYER_TABLE.newGame())
    }

    @Test
    fun `The Skat game is a card game for three or more people - four player`() {
        assertThat(FOUR_PLAYER_TABLE.getPlayerCount()).isEqualTo(4)
        assertThat(FOUR_PLAYER_TABLE.hasEnoughPlayers()).isTrue()
        assertGamePlayerNames(FOUR_PLAYER_TABLE.newGame())
    }

    @Test
    fun `The single game is played by one player and two opponents`() {
        var game = SkatGame(PLAYER_ONE, PLAYER_TWO, PLAYER_THREE)

        assertGamePlayerNames(game)
        assertThat(game.declarer).isEqualTo(PLAYER_ONE)
        assertThat(game.opponents).containsExactly(PLAYER_TWO, PLAYER_THREE)
    }

    private fun assertGamePlayerNames(game: SkatGame) {
        assertThat(game.forehand.name).isEqualTo("Player One")
        assertThat(game.middlehand.name).isEqualTo("Player Two")
        assertThat(game.rearhand.name).isEqualTo("Player Three")
    }
}