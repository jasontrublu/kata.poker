package service

import model.Hand
import model.Result

interface HandComparator {

    Result compare(Hand handOne, Hand handTwo)
}