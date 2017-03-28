package service

import model.Hand
import model.Result
import spock.lang.Specification
import spock.lang.Unroll

import static model.Winner.BLACK
import static model.Winner.TIE
import static model.Winner.WHITE

class HandComparatorSpec extends Specification {
    def "empty comparator"() {
        given:
            HandComparator comp = new HandComparatorImpl()
        when:
            def result = comp.compare(new Hand(), new Hand())
        then:
            result.winner == TIE
    }

    @Unroll
    def "get result from one rule, (#winner, #reason)"() {
        given:
            HandComparator rule = Mock HandComparator
            HandComparator comp = new HandComparatorImpl(rules: [rule])
            1 * rule.compare(*_) >> [winner, reason]
        expect:
            comp.compare(new Hand(), new Hand()) == new Result(winner, reason)
        where:
            winner | reason
            BLACK  | "high card: ace"
            BLACK  | "high card: two"
            WHITE  | "high card: ace"
            WHITE  | "high card: king"
    }

    @Unroll
    def "use two comparators, first is #first, second is #second result: #winner"() {
        given:
            HandComparator rule1 = Mock HandComparator
            HandComparator rule2 = Mock HandComparator
            HandComparator comp = new HandComparatorImpl(rules: [rule1, rule2])
            1 * rule1.compare(*_) >> [first, reason]
            rule2.compare(*_) >> [second, reason]
        expect:
            comp.compare(new Hand(), new Hand()) == new Result(winner, winReason)
        where:
            first | reason           | second | winner | winReason
            BLACK | "high card: ace" | WHITE  | BLACK  | "high card: ace"
            TIE   | "high card: ace" | WHITE  | WHITE  | "high card: ace"
            TIE   | "high card: ace" | TIE    | TIE    | ""
    }
}
