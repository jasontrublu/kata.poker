package service

import model.Result

class OutputFormatterImpl implements OutputFormatter {
    @Override
    String format(Result result) {
        result.getOutput(" wins. - with %s")
    }
}
