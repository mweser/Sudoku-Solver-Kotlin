package solver

import components.Cell
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

            if (valuesList.size == 2) {
                for (value in valuesList) {
                    cellLists.add(row.getCellsWithCandidateValue(value))
                }

                if (doCellsHoldHiddenDouble(cellLists[0], cellLists[1])) {

                    count++
                    printHiddenDoubleResults(cellLists[0][0], cellLists[0][1])

                    for (cell in cellLists[0]) {
                        cell.eliminateAllCandidatesExcept(valuesList[0], valuesList[1])
                    }
                    printHiddenDoubleElimination(cellLists[0][0], cellLists[0][1])
                    count += DoubleNaked.check()
                }
            }
        }

        return count
    }

    fun doCellsHoldHiddenDouble(cellList1: ArrayList<Cell>, cellList2: ArrayList<Cell>): Boolean {

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


        return true
    }

}