package solver

import components.Candidates
import components.Cell
import components.Row
import components.Table
import util.Logger.printFoundNakedDoubles
import util.Logger.printNakedDoublesResults

object DoubleNaked : RuleCheck() {

    var count = 0

    override fun check(table: Table): Int {
        count = 0
        for (cell in table.cells) if (cell.getNumCandidates() == 2) {
            checkForIdenticalCandidatePair(table, cell)
        }

        printNakedDoublesResults(this)
        return count
    }

    fun checkForIdenticalCandidatePair(table: Table, cell: Cell) {
        checkForIdenticalCandidatePair(table, cell, cell.row)
        checkForIdenticalCandidatePair(table, cell, cell.column)
        checkForIdenticalCandidatePair(table, cell, cell.block)
    }

    fun <T : Row> checkForIdenticalCandidatePair(table: Table, cell: Cell, rowType: T) {

        for (matchingCell in rowType.getOtherCells(cell)) {
            if (matchingCell.getNumCandidates() == 2 && doCandidatesMatch(matchingCell.candidates, cell.candidates)) {

                for (otherCell in rowType.getOtherCells(cell, matchingCell)) {
                    if (otherCell.eliminateCandidates(cell.candidates) != 0) {
                        count++
                        printFoundNakedDoubles(cell, matchingCell, cell.candidates, rowType)
                    }
                }
                count += SingleHidden.check(table)
            }
        }
    }

    fun doCandidatesMatch(candidates1: Candidates, candidates2: Candidates): Boolean {
        if (candidates1.candidates.size != candidates2.candidates.size) {
            return false
        }

        for (index in 0 until candidates1.candidates.size) {
            if (candidates1.candidates[index] != candidates2.candidates[index]) {
                return false
            }
        }

        return true
    }

}