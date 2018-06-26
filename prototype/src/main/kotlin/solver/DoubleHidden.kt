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

                if (doCellsHoldHiddenDouble(cellLists[0], cellLists[1])) {


                }
            }
        }

        return count
    }

    private fun reduceCellListsToMatching(cellLists: ArrayList<ArrayList<Cell>>): ArrayList<ArrayList<Cell>> {
        var reducedLists = cellLists

        for (i in 0 until cellLists.size) {
            for (j in i until cellLists.size) {




            }
        }

        return reducedLists
    }

    fun doCellsHoldHiddenDouble(valuesList: ArrayList<CellValue>,cellLists: ArrayList<ArrayList<Cell>>, cellList1: ArrayList<Cell>, cellList2: ArrayList<Cell>): Boolean {

        if (cellList1.size != cellList2.size || cellList1.size != 2) {
            return false
        }

        for (index in 0 until cellList1.size) {

            if (cellList1[index].index != cellList2[index].index) {
                return false
            }

            if (cellList1[index].getNumCandidates() == 2 && cellList2[index].getNumCandidates() == 2) {
                return false
            }
        }

        count++
        printHiddenDoubleResults(cellList1[0], cellList1[1])

        for (cell in cellLists[0]) {
            cell.eliminateAllCandidatesExcept(valuesList[0], valuesList[1])
        }
        printHiddenDoubleElimination(cellList1[0], cellList1[1])
        count += DoubleNaked.check()

        return true
    }

}