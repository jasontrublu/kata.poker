package service

import model.Winner

interface OutputFormatter {

    void format(Winner winner, def winningReason)
}