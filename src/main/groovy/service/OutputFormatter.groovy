package service

import model.Result

interface OutputFormatter {

    String format(Result result)
}