package service

import spock.lang.Specification
import spock.lang.Unroll

import static model.Winner.*

class OutputFormatterSpec extends Specification {
    OutputFormatter formatter = new OutputFormatterImpl()

    @Unroll
    def "basic output for #winner and #winningReason"() {
        expect:
            formatter.format(winner, winningReason) == result
        where:
            winner | winningReason    | result
            BLACK  | "flash"          | "Black wins. - with flash"
            WHITE  | "flash"          | "White wins. - with flash"
            WHITE  | "high card: Ace" | "White wins. - with high card: Ace"
            TIE    | ""               | "Tie"
    }
}
