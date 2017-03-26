package service

import model.Winner

interface OutputFormatter {

    String format(Winner winner, def String winningReason)
}