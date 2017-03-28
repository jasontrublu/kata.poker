package service

import model.Hand
import model.Winner

class HandComparatorImpl implements HandComparator {
    Collection<HandComparator> rules = []

    @Override
    Tuple2 compare(Hand handOne, Hand handTwo) {
        if (rules.empty) {
            return new Tuple2(Winner.TIE, "")
        }
        return rules.stream()
            .map({ it.compare(handOne, handTwo) })
            .filter({ it.getFirst() != Winner.TIE })
            .findFirst()
            .orElse(new Tuple2(Winner.TIE, ""))
    }
}
