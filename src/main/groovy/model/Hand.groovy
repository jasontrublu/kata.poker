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
            .map({ x -> x.toString() })
            .collect(Collectors.joining(", ", "[", "]"))
    }
}
