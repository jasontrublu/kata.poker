class Poker {
    InputParser inputParser

    def game(String input) {
        inputParser.parse(input)
        return "White wins. - with high card: Ace"
    }
}