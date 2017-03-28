package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {
    @Override
    Result compare(Hand handOne, Hand handTwo) {
        if (handOne.cards.contains(Card.Ace)) {
            return new Result(Winner.WHITE, "")
        }
        return Result.TIE
    }
}
