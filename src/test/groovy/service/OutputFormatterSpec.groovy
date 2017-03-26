package service

import spock.lang.Specification

import static model.Winner.BLACK
import static model.Winner.WHITE

class OutputFormatterSpec extends Specification {
    def "basic output"() {
        OutputFormatter formatter = new OutputFormatterImpl()
        expect:
            formatter.format(winner, winningReason) == result
        where:
            winner | winningReason | result
            BLACK  | "flash"       | "Black wins. - with flash"
            WHITE  | "flash"       | "White wins. - with flash"
    }
}
