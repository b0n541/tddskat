package net.b0n541.skat

class SkatGame(val forehand: SkatPlayer, val middlehand: SkatPlayer, val rearhand: SkatPlayer) {

    private var pickUpSkat = false
    private var gameType: GameType? = null

    /**
     * Declarer player
     *
     * @return Declarer player
     */
    val declarer = forehand

    /**
     * Opponent player
     *
     * @return Opponent players
     */
    val opponents = setOf(middlehand, rearhand)

    /**
     * Skat cards
     *
     * @return Skat cards
     */
    val skat = Pair(Card.CJ, Card.SJ)

    /**
     * Checks whether the game is a hand game.
     *
     * @param TRUE, if the Skat hasn't been picked up
     */
    fun isHand() = !pickUpSkat

    /**
     * Pick up Skat cards.
     */
    fun pickUpSkat() {
        pickUpSkat = true
    }

    /**
     * Gets the game type of the game.
     *
     * @return Game type
     */
    fun getGameType() = gameType

    /**
     * Announce game contract.
     *
     * @param gameType Game type
     * @throws IllegalStateException
     */
    fun announceGameContract(gameType: GameType, hand: Boolean) {
        if (pickUpSkat && hand) {
            throw IllegalStateException("Skat was already picked up. No hand game possible anymore.")
        }
        if (!pickUpSkat && !hand) {
            throw IllegalStateException("Skat was not picked up. Game must be a hand game.")
        }
        this.gameType = gameType
    }
}
