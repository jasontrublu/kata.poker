package service

import model.Hand
import model.Result

class HandComparatorImpl implements HandComparator {
    Collection<HandComparator> rules = []

    @Override
    Result compare(Hand handOne, Hand handTwo) {
        return rules.stream()
            .map({ it.compare(handOne, handTwo) })
            .filter({ !it.isTie() })
            .findFirst()
            .orElse(Result.TIE)
    }
}
