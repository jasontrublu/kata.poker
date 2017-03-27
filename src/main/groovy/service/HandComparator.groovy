package service

import model.Hand

interface HandComparator {

    Tuple compare(Hand handOne, Hand handTwo)
}