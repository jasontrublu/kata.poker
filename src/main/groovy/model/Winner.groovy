package model

enum Winner {
    WHITE(
        name: "White",
        template: "%s wins. - with %s"),
    BLACK(
        name: "Black",
        template: "%s wins. - with %s"),
    TIE(
        name: "Tie",
        template: "%s")

    final String name
    final String template

    def getOutput(reason) {
        return sprintf(template, name, reason)
    }
}
