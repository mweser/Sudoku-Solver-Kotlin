package solver

import components.Cell
import components.CellValue
import components.Row
import components.Table
import util.Logger.printFoundHiddenSingle
import util.Logger.printHiddenSingleResults

object SingleHidden : RuleCheck() {

    var instancesFound = 0

    override fun check(): Int {
        instancesFound = 0

        for (cell in Table.cells) {
            scanRowForUniqueCandidate(cell, cell.row, cell.column, cell.block)
        }

        printHiddenSingleResults(this)
        return instancesFound
    }

    private fun <T : Row> scanRowForUniqueCandidate(cell: Cell, vararg rowTypes: T) {

        for (row in rowTypes) {
            for (value in CellValue.ONE.ordinal..CellValue.NINE.ordinal) {

                if (cell.candidates.contains(value) && row.getCandidateValueCount(value) == 1) {

                    instancesFound++
                    cell.setValueWithRule(CellValue.values()[value], "Hidden single")
                    printFoundHiddenSingle(cell, value)

                    Eliminate.check()
                    SingleNaked.check()
                }
            }

        }
    }
}