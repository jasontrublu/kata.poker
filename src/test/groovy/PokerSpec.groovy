import model.Hand
import service.HandComparator
import service.InputParser
import service.OutputFormatter
import spock.lang.Specification
import spock.lang.Unroll

import static model.Winner.BLACK
import static model.Winner.WHITE

class PokerSpec extends Specification {
    InputParser parser = Mock InputParser
    HandComparator comparator = Mock HandComparator
    OutputFormatter outputFormatter = Mock OutputFormatter

    def poker = new Poker(inputParser: parser, handComparator: comparator, outputFormatter: outputFormatter)

    @Unroll
    def "test that game with input '#input' returns '#output'"() {
        parser.parse(_) >> [new Hand(), new Hand()]
        comparator.compare(*_) >> [BLACK, ""]
        outputFormatter.format(*_) >> output
        expect:
            poker.game(input) == output
        where:
            input                                          | output
            "Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH" | "White wins. - with high card: Ace"
            "Black: 2H 4S 4C 2D 4H  White: 2S 8S AS QS 3S" | "White wins. - with flash"
    }

    def "game send input into service.InputParser"() {
        comparator.compare(*_) >> [BLACK, ""]
        when:
            poker.game("input")
        then:
            1 * parser.parse("input") >> [new Hand(), new Hand()]
    }

    def "game interacts with service.HandComparator and forwards result from service.InputParser"() {
        given:
            Hand handOne = new Hand()
            Hand handTwo = new Hand()
            parser.parse(_) >> [handOne, handTwo]
        when:
            poker.game("")
        then:
            1 * comparator.compare(handOne, handTwo) >> [WHITE, ""]
    }

    @Unroll
    def "game calls outputFormatter with values from service.HandComparator (#winner)"() {
        given:
            parser.parse(_) >> [new Hand(), new Hand()]
            comparator.compare(*_) >> [winner, winningReason]
        when:
            poker.game("input")
        then:
            1 * outputFormatter.format(winner, winningReason)
        where:
            winner << [BLACK, WHITE]
            winningReason << ["high card", "flash"]
            winningValue << ["Ace", ""]
    }
}