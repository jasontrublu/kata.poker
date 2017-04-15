package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

import static model.Result.TIE

class HighCardRule implements HandComparator {

    @Override
    Result compare(final Hand handWhite, final Hand handBlack) {
        return (0..2).stream()
            .map({ index -> getWinner(handWhite.get(index), handBlack.get(index)) })
            .filter({ it != TIE })
            .findFirst()
            .orElse(TIE)
    }

    private static Result getWinner(Card cardWhite, Card cardBlack) {
        def comp = cardWhite <=> cardBlack
        if (comp < 0) {
            return new Result(Winner.BLACK, cardBlack.toString())
        }
        if (comp > 0) {
            return new Result(Winner.WHITE, cardWhite.toString())
        }
        TIE
    }
}