package service

import model.Hand
import model.Winner
import spock.lang.Specification
import spock.lang.Unroll

class HandComparatorSpec extends Specification {
    def "empty comparator"() {
        given:
            HandComparator comp = new HandComparatorImpl()
        when:
            def (Winner winner, String reason) = comp.compare(new Hand(), new Hand())
        then:
            winner == Winner.TIE
    }

    @Unroll
    def "get result from one rule, (#winner, #reason)"() {
        given:
            HandComparator rule = Mock HandComparator
            HandComparator comp = new HandComparatorImpl(rules: [rule])
            1 * rule.compare(*_) >> [winner, reason]
        expect:
            comp.compare(new Hand(), new Hand()) == [winner, reason]
        where:
            winner       | reason
            Winner.BLACK | "high card: ace"
            Winner.BLACK | "high card: two"
            Winner.WHITE | "high card: ace"
            Winner.WHITE | "high card: king"
    }
}
