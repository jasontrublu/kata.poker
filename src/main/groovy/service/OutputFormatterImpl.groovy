package service

import model.Winner

class OutputFormatterImpl implements OutputFormatter {
    @Override
    String format(Winner winner, def String winningReason) {
        winner.getOutput(" wins. - with " + winningReason)
    }
}
