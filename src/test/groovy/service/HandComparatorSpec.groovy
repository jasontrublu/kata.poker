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
}
