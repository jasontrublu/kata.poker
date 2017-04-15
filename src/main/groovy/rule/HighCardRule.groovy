package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {

    @Override
    Result compare(final Hand handWhite, final Hand handBlack) {
        Result out = getWinner(handWhite.get(0), handBlack.get(0))
        if (out != Result.TIE) {
            return out
        }
        out = getWinner(handWhite.get(1), handBlack.get(1))
        if (out != Result.TIE) {
            return out
        }
        out = getWinner(handWhite.get(2), handBlack.get(2))
        return out
    }

    private static Result getWinner(Card cardWhite, Card cardBlack) {
        def comp = cardWhite <=> cardBlack
        if (comp < 0) {
            return new Result(Winner.BLACK, cardBlack.toString())
        }
        if (comp > 0) {
            return new Result(Winner.WHITE, cardWhite.toString())
        }
        Result.TIE
    }
}