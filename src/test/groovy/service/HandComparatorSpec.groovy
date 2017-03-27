package service

import model.Hand
import model.Winner
import spock.lang.Specification

class HandComparatorSpec extends Specification {
    def "empty comparator"() {
        given:
            HandComparator comp = new HandComparatorImpl()
        when:
            def (Winner winner, String reason) = comp.compare(new Hand(), new Hand())
        then:
            winner == Winner.TIE
    }

    def "one sub comparator"() {
        given:
            HandComparator sub = Mock HandComparator
            HandComparator comp = new HandComparatorImpl(rules: [sub])
            sub.compare(*_) >> [Winner.BLACK, "high card: ace"]
        when:
            def (Winner winner, String reason) = comp.compare(new Hand(), new Hand())
        then:
            winner == Winner.BLACK
            reason == "high card: ace"

    }
}
