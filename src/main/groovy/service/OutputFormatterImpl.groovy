package service

import model.Winner

class OutputFormatterImpl implements OutputFormatter {
    @Override
    String format(Winner winner, def String winningReason) {
        winner.isTie() ? winner.name : winner.name + " wins. - with ${winningReason}"
    }
}
