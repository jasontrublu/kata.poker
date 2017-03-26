package service

import model.Winner

class OutputFormatterImpl implements OutputFormatter {
    @Override
    String format(Winner winner, def String winningReason) {
        return (winner == Winner.BLACK ? "Black" : "White") + " wins. - with flash"
    }
}
