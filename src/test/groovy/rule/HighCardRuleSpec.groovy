package rule

import model.Hand
import model.Result
import model.Winner
import spock.lang.Specification

import static model.Card.ACE
import static model.Card.THREE
import static model.Card.TWO

class HighCardRuleSpec extends Specification {

    def "One ace is higher than a two"() {
        when:
            def result = new HighCardRule().compare(new Hand(ACE), new Hand(TWO))
        then:
            result == new Result(Winner.WHITE, "")
    }

    def "One three is higher than a two"() {
        when:
            def result = new HighCardRule().compare(new Hand(THREE), new Hand(TWO))
        then:
            result == new Result(Winner.WHITE, "")
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