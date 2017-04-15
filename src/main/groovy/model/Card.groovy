package model

class Card implements Comparable<Card> {
    final static Card NIL = new Card(Value.NIL)
    final static Card TWO = new Card(Value.TWO)
    final static Card THREE = new Card(Value.THREE)
    final static Card FOUR = new Card(Value.FOUR)
    final static Card FIVE = new Card(Value.FIVE)
    final static Card SIX = new Card(Value.SIX)
    final static Card SEVEN = new Card(Value.SEVEN)
    final static Card EIGHT = new Card(Value.EIGHT)
    final static Card NINE = new Card(Value.NINE)
    final static Card JACK = new Card(Value.JACK)
    final static Card QUEEN = new Card(Value.QUEEN)
    final static Card TEN = new Card(Value.TEN)
    final static Card KING = new Card(Value.KING)
    final static Card ACE = new Card(Value.ACE)

    private final Value value

    Card(Value value) {
        this.value = value
    }

    @Override
    int compareTo(Card o) {
        return value <=> o.value
    }

    @Override
    String toString() {
        return value.name()
    }
}

enum Value {
    NIL, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
}