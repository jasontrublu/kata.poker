package model

import spock.lang.Specification
import spock.lang.Unroll

import static model.Card.ACE
import static model.Card.FIVE
import static model.Card.KING
import static model.Card.NIL
import static model.Card.NINE
import static model.Card.QUEEN
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

    def "toString gets a nice list of Cards: two cards (with list constructor)"() {
        when:
            def result = new Hand(ACE, TWO).toString()
        then:
            result == "[ACE, TWO]"
    }

    @Unroll
    def "Hand has always five cards, only #name specified"() {
        expect:
            new Hand(cards) == new Hand(expectedHand)
        where:
            name    | cards                        | expectedHand
            "one"   | [ACE]                        | [ACE, NIL, NIL, NIL, NIL]
            "two"   | [ACE, KING]                  | [ACE, KING, NIL, NIL, NIL]
            "three" | [ACE, KING, QUEEN]           | [ACE, KING, QUEEN, NIL, NIL]
            "four"  | [ACE, KING, NINE, FIVE]      | [ACE, KING, NINE, FIVE, NIL]
            "four"  | [ACE, KING, NINE, FIVE, TWO] | [ACE, KING, NINE, FIVE, TWO]
    }
}
