package service

import model.Hand
import model.Result
import model.Winner

class HandComparatorImpl implements HandComparator {
    Collection<HandComparator> rules = []

    @Override
    Result compare(Hand handOne, Hand handTwo) {
        if (rules.empty) {
            return new Result(Winner.TIE, "")
        }
        return rules.stream()
            .map({ it.compare(handOne, handTwo) })
            .filter({ it.winner != Winner.TIE })
            .findFirst()
            .orElse(new Result(Winner.TIE, ""))
    }
}
