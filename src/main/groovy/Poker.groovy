import service.HandComparator
import service.InputParser
import service.OutputFormatter

class Poker {
    InputParser inputParser
    HandComparator handComparator
    OutputFormatter outputFormatter

    def game(String input) {
        outputFormatter.format(handComparator.compare(inputParser.parse(input)))
        return "White wins. - with high card: Ace"
    }
}