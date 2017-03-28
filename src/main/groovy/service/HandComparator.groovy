package service

import model.Hand
import model.Result

interface HandComparator {

    Result compare(Hand handWhite, Hand handBlack)
}