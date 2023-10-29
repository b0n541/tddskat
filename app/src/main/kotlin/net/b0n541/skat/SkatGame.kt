package net.b0n541.skat

class SkatGame(val forehand: SkatPlayer, val middlehand: SkatPlayer, val rearhand: SkatPlayer) {
    val declarer = forehand
    val opponents = listOf(middlehand, rearhand)
}
