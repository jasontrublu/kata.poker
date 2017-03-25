import spock.lang.Specification
import spock.lang.Unroll

class PokerSpec extends Specification {
    InputParser parser = Mock(InputParser)
    def poker = new Poker(inputParser: parser)

    @Unroll
    def "test that game with input '#input' returns '#output'"() {
        expect:
            poker.game(input) == output
        where:
            input                                          | output
            "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH" | "White wins. - with high card: Ace"
    }

    def "game send input into input parser"() {
        when:
            poker.game("input")
        then:
            1 * parser.parse("input")
    }
}
