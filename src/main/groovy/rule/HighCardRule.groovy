package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {
    @Override
    Result compare(Hand handWhite, Hand handBlack) {
        if (handWhite.cards.contains(Card.ACE)) {
            if (!handBlack.cards.contains(Card.ACE)) {
                return new Result(Winner.WHITE, "")
            }
        } else if (handBlack.cards.contains(Card.ACE)) {
            return new Result(Winner.BLACK, "")
        }
        if (handWhite.cards.contains(Card.THREE)) {
            return new Result(Winner.WHITE, "")
        }
        return Result.TIE
    }
}