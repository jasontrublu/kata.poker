package model

import java.util.stream.Collectors

class Hand {
    List<Card> cards = []

    Hand(Card... cards) {
        this.cards = cards
    }

    Card first() {
        cards.first()
    }

    Card get(int index) {
        cards.get(index)
    }

    @Override
    String toString() {
        return cards.stream()
            .map({ it.toString() })
            .collect(Collectors.joining(", ", "[", "]"))
    }
}
