package org.bonsai.tddskat

data class SkatGame(val players: List<SkatPlayer>) {
    fun getDeclarer(): SkatPlayer {
        return players.get(0)
    }
}