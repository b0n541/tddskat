package org.b0n541.tddskat.rule

import org.assertj.core.api.Assertions.assertThat
import org.b0n541.tddskat.Skat
import org.b0n541.tddskat.SkatGame
import org.b0n541.tddskat.SkatPlayer
import org.junit.jupiter.api.Test


class SkatTest {

    @Test
    fun `Skat is played by three or more players`() {
        val skatWithThreePlayers = Skat(listOf(SkatPlayer("Klaus"), SkatPlayer("Lutz"), SkatPlayer("Fritz")))
        assertThat(skatWithThreePlayers.players).hasSize(3)

        val skatWithFivePlayers = Skat(listOf(SkatPlayer("Klaus"), SkatPlayer("Lutz"), SkatPlayer("Fritz"),
                SkatPlayer("Paul"), SkatPlayer("Hans")))
        assertThat(skatWithFivePlayers.players).hasSize(5)
    }

    @Test
    fun `Skat game is played by declarer against two defenders`() {
        val game = SkatGame(listOf(SkatPlayer("Declarer"), SkatPlayer("Defender"), SkatPlayer("Defender")))
        assertThat(game.players).hasSize(3)
        assertThat(game.getDeclarer()).isEqualTo(SkatPlayer("Declarer"))
    }
}