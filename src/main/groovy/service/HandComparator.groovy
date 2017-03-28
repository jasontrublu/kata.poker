package service

import model.Hand

interface HandComparator {

    Tuple2 compare(Hand handOne, Hand handTwo)
}