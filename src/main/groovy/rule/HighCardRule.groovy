package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {
    @Override
    Result compare(Hand handWhite, Hand handBlack) {
        if (handWhite.cards.contains(Card.Ace)) {
            return new Result(Winner.WHITE, "")
        }
        if (handBlack.cards.contains(Card.Ace)) {
            return new Result(Winner.BLACK, "")
        }
        return Result.TIE
    }
}
