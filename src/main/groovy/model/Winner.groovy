package model

enum Winner {
    WHITE(name: "White"),
    BLACK(name: "Black"),
    TIE(name: "Tie")

    final String name

    boolean isTie() {
        this == TIE
    }
}
