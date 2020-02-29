package org.b0n541.tddskat

data class SkatGame(val players: List<SkatPlayer>) {
    fun getDeclarer(): SkatPlayer {
        return players.get(0)
    }
}