package net.b0n541.skat

class SkatGame(val forehand: SkatPlayer, val middlehand: SkatPlayer, val rearhand: SkatPlayer) {
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
}
