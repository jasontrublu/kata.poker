package rule

import model.Card
import model.Hand
import model.Result
import model.Winner
import spock.lang.Specification

class HighCardRuleSpec extends Specification {
    def "two empty hand result in tie"() {
        expect:
            new HighCardRule().compare(new Hand(), new Hand()) == Result.TIE
    }

    def "One ace is higher than a two"() {
        when:
            def result = new HighCardRule().compare(new Hand(Card.Ace), new Hand(Card.Two))
        then:
            result == new Result(Winner.WHITE, "")

    }
}