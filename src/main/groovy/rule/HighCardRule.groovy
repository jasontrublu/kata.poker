package rule

import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {
    @Override
    Result compare(final Hand handWhite, final Hand handBlack) {
        def cardWhite = handWhite.cards.first()
        def cardBlack = handBlack.cards.first()
        def comp = cardWhite <=> cardBlack
        if (comp < 0) {
            return new Result(Winner.BLACK, cardBlack.toString())
        }
        if (comp > 0) {
            return new Result(Winner.WHITE, cardWhite.toString())
        }
        if (handWhite.cards.size() > 1 && handBlack.cards.size() > 1 ) {
            cardWhite = handWhite.cards.get(1)
            cardBlack = handBlack.cards.get(1)
            comp = cardWhite <=> cardBlack
            if (comp < 0) {
                return new Result(Winner.BLACK, cardBlack.toString())
            }
            if (comp > 0) {
                return new Result(Winner.WHITE, cardWhite.toString())
            }
        }
        return Result.TIE
    }
}