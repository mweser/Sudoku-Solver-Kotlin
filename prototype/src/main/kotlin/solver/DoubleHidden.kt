package solver

import components.Cell
import components.CellValue
import components.Row
import components.Table
import util.Logger.printHiddenDoubleElimination
import util.Logger.printHiddenDoubleResults

object DoubleHidden : RuleCheck() {

    var count = 0

    override fun check(): Int {
        count = 0

        scanRowType(Table.rows)
        scanRowType(Table.columns)
        scanRowType(Table.blocks)

        return count
    }

    fun <T : Row> scanRowType(rows: Array<T>): Int {

        for (row in rows) {

            var valuesList = row.getCandidateValuesWithNumOccurrences(2)
            var cellLists = ArrayList<ArrayList<Cell>>()

            if (valuesList.size >= 2) {
                for (value in valuesList) {
                    cellLists.add(row.getCellsWithCandidateValue(value))
                }

                cellLists = reduceCellListsToMatching(cellLists)

                if (processAnyHiddenDoubles(cellLists[0], cellLists[1])) {


                }
            }
        }

        return count
    }

    private fun reduceCellListsToMatching(cellLists: ArrayList<ArrayList<Cell>>): ArrayList<ArrayList<Cell>> {
        var reducedLists = ArrayList<ArrayList<Cell>>()

        for (i in 0 until cellLists.size) {
            for (j in i until cellLists.size) {

                if (hasHiddenDoublePair(cellLists[i], cellLists[j])) {
                    reducedLists.add()
                }


            }
        }

        return reducedLists
    }

    fun hasHiddenDoublePair(cellPair1: ArrayList<Cell>, cellPair2: ArrayList<Cell>): Boolean {
        return false
    }

    fun processAnyHiddenDoubles(valuesList: ArrayList<CellValue>, cellLists: ArrayList<ArrayList<Cell>>, cellPair1: ArrayList<Cell>, cellPair2: ArrayList<Cell>): Boolean {

        if (cellPair1.size != cellPair2.size || cellPair1.size != 2) {
            return false
        }

        for (index in 0 until cellPair1.size) {

            if (cellPair1[index].index != cellPair2[index].index) {
                return false
            }

            if (cellPair1[index].getNumCandidates() == 2 && cellPair2[index].getNumCandidates() == 2) {
                return false
            }
        }

        count++
        printHiddenDoubleResults(cellPair1[0], cellPair1[1])

        for (cell in cellLists[0]) {
            cell.eliminateAllCandidatesExcept(valuesList[0], valuesList[1])
        }
        printHiddenDoubleElimination(cellPair1[0], cellPair1[1])
        count += DoubleNaked.check()

        return true
    }

}