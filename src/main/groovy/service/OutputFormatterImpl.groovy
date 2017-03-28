package service

import model.Result

class OutputFormatterImpl implements OutputFormatter {
    @Override
    String format(Result result) {
        result.winner.getOutput(" wins. - with " + result.reason)
    }
}
