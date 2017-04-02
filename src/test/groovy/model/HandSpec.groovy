package model

import spock.lang.Specification

import static model.Card.ACE
import static model.Card.TWO

class HandSpec extends Specification {

    def "toString gets a nice list of Cards"() {
        when:
            def result = new Hand(ACE).toString()
        then:
            result == "[ACE]"
    }

    def "toString gets a nice list of Cards: two cards"() {
        when:
            def result = new Hand(ACE, TWO).toString()
        then:
            result == "[ACE, TWO]"
    }
}
