import model.Hand
import model.Result
import service.HandComparator
import service.InputParser
import service.OutputFormatter
import service.OutputFormatterImpl
import spock.lang.Specification
import spock.lang.Unroll

import static model.Winner.BLACK
import static model.Winner.TIE
import static model.Winner.WHITE

class PokerOutputSpec extends Specification {

    InputParser parser = Mock InputParser
    HandComparator comparator = Mock HandComparator
    OutputFormatter outputFormatter = new OutputFormatterImpl()

    def poker = new Poker(inputParser: parser, handComparator: comparator, outputFormatter: outputFormatter)

    @Unroll
    def "use formatter impl in Poker with #winner and #winningReason"() {
        given:
            parser.parse(_) >> [new Hand(), new Hand()]
            comparator.compare(*_) >> new Result(winner, winningReason)
        expect:
            poker.game("input") == result
        where:
            winner | winningReason    | result
            BLACK  | "flash"          | "Black wins. - with flash"
            WHITE  | "flash"          | "White wins. - with flash"
            WHITE  | "high card: Ace" | "White wins. - with high card: Ace"
            TIE    | ""               | "Tie"
    }
}
