package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {
    @Override
    Result compare(final Hand handWhite, final Hand handBlack) {
        Card cardWhite = handWhite.cards.first()
        Card cardBlack = handBlack.cards.first()
        def comp = cardWhite <=> cardBlack
        if (comp < 0) {
            return new Result(Winner.BLACK, cardBlack.toString())
        }
        if (comp > 0) {
            return new Result(Winner.WHITE, cardWhite.toString())
        }
        return Result.TIE
    }
}