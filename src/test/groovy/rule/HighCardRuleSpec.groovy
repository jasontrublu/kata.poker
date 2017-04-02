package rule

import model.Hand
import model.Result
import model.Winner
import spock.lang.Specification
import spock.lang.Unroll

import static model.Card.ACE
import static model.Card.THREE
import static model.Card.TWO
import static model.Winner.WHITE

class HighCardRuleSpec extends Specification {

    @Unroll
    def "#winner wins because #reason with #whiteHand vs. #blackHand "() {
        expect:
            new HighCardRule().compare(whiteHand, blackHand) == new Result(winner, reason)
        where:
            winner | reason | whiteHand     | blackHand
            WHITE  | ""     | new Hand(ACE) | new Hand(TWO)
    }

    def "One three is higher than a two"() {
        when:
            def result = new HighCardRule().compare(new Hand(THREE), new Hand(TWO))
        then:
            result == new Result(WHITE, "")
    }

    def "ace from black hand is higher than white hand with a two"() {
        when:
            def result = new HighCardRule().compare(new Hand(TWO), new Hand(ACE))
        then:
            result == new Result(Winner.BLACK, "")
    }

    def "both players have same Card, results in tie"() {
        when:
            def result = new HighCardRule().compare(new Hand(ACE), new Hand(ACE))
        then:
            result == Result.TIE
    }
}