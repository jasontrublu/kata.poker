package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import service.HandComparator

class HighCardRule implements HandComparator {
    
    @Override
    Result compare(final Hand handWhite, final Hand handBlack) {
        def cardWhite = handWhite.cards.first()
        def cardBlack = handBlack.cards.first()
        Result out = getWinner(cardWhite, cardBlack)
        if (out != Result.TIE) {
            return out
        }
        if (handWhite.cards.size() > 1 && handBlack.cards.size() > 1) {
            cardWhite = handWhite.cards.get(1)
            cardBlack = handBlack.cards.get(1)
            out = getWinner(cardWhite, cardBlack)
        }
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