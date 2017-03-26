import spock.lang.Specification
import spock.lang.Unroll

class PokerSpec extends Specification {
    InputParser parser = Mock InputParser
    HandComparator comparator = Mock HandComparator
    OutputFormatter outputFormatter = Mock OutputFormatter

    def poker = new Poker(inputParser: parser, handComparator: comparator, outputFormatter: outputFormatter)

    @Unroll
    def "test that game with input '#input' returns '#output'"() {
        parser.parse(_) >> [new Hand(), new Hand()]
        expect:
            poker.game(input) == output
        where:
            input                                          | output
            "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH" | "White wins. - with high card: Ace"
    }

    def "game send input into InputParser"() {
        when:
            poker.game("input")
        then:
            1 * parser.parse("input") >> [new Hand(), new Hand()]
    }

    def "game interacts with HandComparator and forwards result from InputParser"() {
        given:
            Hand handOne = new Hand()
            Hand handTwo = new Hand()
            parser.parse(_) >> [handOne, handTwo]
        when:
            poker.game("")
        then:
            1 * comparator.compare(handOne, handTwo)
    }

    def "game interacts with outputFormatter"() {
        given:
            parser.parse(_) >> [new Hand(), new Hand()]
        when:
            poker.game("input")
        then:
            1 * outputFormatter.format("", "", "")
    }
}
