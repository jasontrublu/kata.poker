package model

import groovy.transform.EqualsAndHashCode

import java.util.stream.Collectors

import static model.Card.getNIL

@EqualsAndHashCode
class Hand {
    private final List<Card> cards = []

    Hand(Card... cards) {
        this(cards as List)
    }

    Hand(List<Card> cards) {
        List inputClone = cards.clone()
        while (inputClone.size() != 5) {
            inputClone.add(NIL)
        }
        this.cards = inputClone.asImmutable()
    }

    Card get(int index) {
        cards.get(index)
    }


    @Override
    String toString() {
        return cards.stream()
            .filter({ (it != NIL) })
            .map({ it.toString() })
            .collect(Collectors.joining(", ", "[", "]"))
    }
}
