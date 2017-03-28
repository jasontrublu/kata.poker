package service

import model.Hand
import model.Result

class HandComparatorImpl implements HandComparator {
    Collection<HandComparator> rules = []

    @Override
    Result compare(Hand handWhite, Hand handBlack) {
        return rules.stream()
            .map({ it.compare(handWhite, handBlack) })
            .filter({ !it.isTie() })
            .findFirst()
            .orElse(Result.TIE)
    }
}
