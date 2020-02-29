package org.bonsai.tddskat.rule

import org.assertj.core.api.Assertions.assertThat
import org.bonsai.tddskat.Skat
import org.bonsai.tddskat.SkatGame
import org.bonsai.tddskat.SkatPlayer
import org.junit.Test


class OverviewTest {

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