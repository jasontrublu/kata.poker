package model

import java.util.stream.Collectors

class Hand {
    final List<Card> cards = []

    Hand(Card... cards) {
        this.cards = cards.clone()
    }

    Hand(List<Card> cards) {
        this.cards = cards.clone()
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
