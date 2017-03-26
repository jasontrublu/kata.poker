package service

import model.Winner

interface OutputFormatter {

    def format(Winner winner, def winningReason)
}