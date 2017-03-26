package service

import model.Winner

class OutputFormatterImpl implements OutputFormatter {
    @Override
    String format(Winner winner, def String winningReason) {
        if (winner == winner.TIE) {
            return "Tie"
        }
        return (winner == Winner.BLACK ? "Black" : "White") + " wins. - with ${winningReason}"
    }
}
