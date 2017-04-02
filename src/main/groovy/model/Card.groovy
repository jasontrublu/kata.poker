package model

class Card implements Comparable<Card> {
    final static Card ACE = new Card(Suit.ACE)
    final static Card TWO = new Card(Suit.TWO)
    final static Card THREE = new Card(Suit.THREE)

    private final Suit suit

    Card(Suit suit) {
        this.suit = suit
    }

    @Override
    int compareTo(Card o) {
        return suit.compareTo(o.suit)
    }

    @Override
    String toString() {
        return suit.name()
    }
}

enum Suit {
    TWO,
    THREE,
    ACE
}