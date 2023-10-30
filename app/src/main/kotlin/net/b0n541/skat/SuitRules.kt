package net.b0n541.skat

class SuitRules {
    companion object {
        fun trumps(game: SkatGame, suit1: Suit, suit2: Suit): Boolean {
            return game.getTrumpSuit() == suit1 && game.getTrumpSuit() != suit2
        }

        fun equal(game: SkatGame, suit1: Suit, suit2: Suit): Boolean {
            return game.getTrumpSuit() == suit1 && game.getTrumpSuit() == suit2
                    || game.getTrumpSuit() != suit1 && game.getTrumpSuit() != suit2
        }
    }
}