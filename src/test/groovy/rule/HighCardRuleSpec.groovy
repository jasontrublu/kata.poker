package rule

import model.Card
import model.Hand
import model.Result
import model.Value
import spock.lang.Specification
import spock.lang.Unroll

import static model.Card.ACE
import static model.Card.EIGHT
import static model.Card.FIVE
import static model.Card.FOUR
import static model.Card.JACK
import static model.Card.KING
import static model.Card.NINE
import static model.Card.QUEEN
import static model.Card.SEVEN
import static model.Card.SIX
import static model.Card.TEN
import static model.Card.THREE
import static model.Card.TWO
import static model.Winner.BLACK
import static model.Winner.WHITE

class HighCardRuleSpec extends Specification {

    @Unroll
    def "#winner wins because #reason with #whiteHand vs. #blackHand "() {
        expect:
            new HighCardRule().compare(whiteHand, blackHand) == new Result(winner, reason)
        where:
            winner | reason  | whiteHand       | blackHand
            WHITE  | "ACE"   | new Hand(ACE)   | new Hand(TWO)
            WHITE  | "THREE" | new Hand(THREE) | new Hand(TWO)
            BLACK  | "ACE"   | new Hand(TWO)   | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(THREE) | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(FOUR)  | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(FIVE)  | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(SIX)   | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(SEVEN) | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(EIGHT) | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(NINE)  | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(TEN)   | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(JACK)  | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(QUEEN) | new Hand(ACE)
            BLACK  | "ACE"   | new Hand(KING)  | new Hand(ACE)
            WHITE  | "THREE" | new Hand(THREE) | new Hand(TWO)
            WHITE  | "FOUR"  | new Hand(FOUR)  | new Hand(THREE)
            WHITE  | "FIVE"  | new Hand(FIVE)  | new Hand(FOUR)
            WHITE  | "SIX"   | new Hand(SIX)   | new Hand(FIVE)
            WHITE  | "SEVEN" | new Hand(SEVEN) | new Hand(SIX)
            WHITE  | "EIGHT" | new Hand(EIGHT) | new Hand(SEVEN)
            WHITE  | "NINE"  | new Hand(NINE)  | new Hand(EIGHT)
            WHITE  | "TEN"   | new Hand(TEN)   | new Hand(NINE)
            WHITE  | "JACK"  | new Hand(JACK)  | new Hand(TEN)
            WHITE  | "KING"  | new Hand(KING)  | new Hand(JACK)
            WHITE  | "ACE"   | new Hand(ACE)   | new Hand(KING)
    }

    @Unroll
    def "both players have same Card #card, results in tie"() {
        def handWhite = new Hand(new Card(card))
        def handBlack = new Hand(new Card(card))
        expect:
            new HighCardRule().compare(handWhite, handBlack) == Result.TIE
        where:
            card << Value.values()
    }
}