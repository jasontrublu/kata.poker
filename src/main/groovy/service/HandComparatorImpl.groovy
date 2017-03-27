package service

import model.Hand
import model.Winner

class HandComparatorImpl implements HandComparator {
    Collection<HandComparator> rules = []

    @Override
    Tuple compare(Hand handOne, Hand handTwo) {
        if (rules.empty) {
            return new Tuple(Winner.TIE, "")
        }
        return rules[0].compare(handOne, handTwo)
    }
}
