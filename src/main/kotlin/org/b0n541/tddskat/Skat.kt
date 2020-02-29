package org.b0n541.tddskat

data class Skat(val players: List<SkatPlayer>) {
    init {
        if (players.size < 3) {
            throw IllegalArgumentException("Skat is played by at least 3 players.")
        }
    }
}