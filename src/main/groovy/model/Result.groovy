package model

import groovy.transform.Immutable

@Immutable
class Result {
    public static final TIE = new Result(Winner.TIE, "")

    Winner winner
    String reason

    String getOutput(String template) {
        winner.getOutput(sprintf(template, reason))
    }

    def isTie() {
        winner == Winner.TIE
    }
}
