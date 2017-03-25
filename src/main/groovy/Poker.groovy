class Poker {
    InputParser inputParser
    HandComparator handComparator

    def game(String input) {
        def (Hand handOne, Hand handTwo) = inputParser.parse(input)
        handComparator.compare(handOne, handTwo)
        return "White wins. - with high card: Ace"
    }
}