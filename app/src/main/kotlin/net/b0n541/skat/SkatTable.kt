package net.b0n541.skat

/**
 * Skat table
 *
 * @param initialPlayer Initial player
 */
class SkatTable(initialPlayer: List<SkatPlayer>) {

    private val player: MutableList<SkatPlayer> = initialPlayer.toMutableList()

    /**
     * Creates a new game on the table.
     *
     * @return New game
     * @throws IllegalStateException
     */
    fun newGame(): SkatGame {
        if (!hasEnoughPlayers()) {
            throw IllegalStateException("At least 3 players are needed to play a game of Skat. Currently only ${player.size} player sit at the table.")
        }
        return SkatGame(player[0], player[1], player[2])
    }

    /**
     * Get player count.
     *
     * @return Player count
     */
    fun getPlayerCount() = player.size

    /**
     * Checks whether enough player are sitting at the table.
     *
     * @return TRUE, if at least three player are sitting at the table
     */
    fun hasEnoughPlayers() = player.size >= 3
}
