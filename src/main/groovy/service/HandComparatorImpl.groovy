package service

import model.Hand
import model.Winner

class HandComparatorImpl implements HandComparator {
    @Override
    Tuple compare(Hand handOne, Hand handTwo) {
        return new Tuple(Winner.TIE, "")
    }
}
