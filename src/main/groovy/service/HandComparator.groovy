package service

import model.Hand
import model.Result

interface HandComparator {

    Result compare(final Hand handWhite, final Hand handBlack)
}