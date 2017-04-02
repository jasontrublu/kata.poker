package model

import java.util.stream.Collectors

class Hand {
    List<Card> cards = []

    Hand(Card... cards) {
        this.cards = cards
    }

    @Override
    String toString() {
        return cards.stream()
            .map({ it.toString() })
            .collect(Collectors.joining(", ", "[", "]"))
    }
}
