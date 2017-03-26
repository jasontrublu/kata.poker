package service

import model.Hand

interface HandComparator {

    def compare(Hand handOne, Hand handTwo)
}