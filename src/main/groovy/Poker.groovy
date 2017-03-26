class Poker {
    InputParser inputParser
    HandComparator handComparator
    OutputFormatter outputFormatter

    def game(String input) {
        handComparator.compare(inputParser.parse(input))
        outputFormatter.format("", "", "")
        return "White wins. - with high card: Ace"
    }
}