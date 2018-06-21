package solver

import components.Cell
import components.CellValue
import components.Row
import components.Table

object SingleHidden : RuleCheck() {

    var instancesFound = 0

    override fun check(): Int {
        instancesFound = 0

        for (cell in Table.cells) {
            scanRowForUniqueCandidate(cell, cell.row, cell.column, cell.block)
        }

        println("\nHidden single check: $instancesFound instances found\n")
        return instancesFound
    }

    private fun <T : Row> scanRowForUniqueCandidate(cell: Cell, vararg rowTypes: T) {

        for (row in rowTypes) {

            for (value in CellValue.ONE.ordinal..CellValue.NINE.ordinal) {

                if (cell.candidates.contains(value) && row.getCandidateValueCount(value) == 1) {

                    instancesFound++
                    cell.value = CellValue.values()[value]
                    println("Hidden single found for ${CellValue.values()[value]} in $cell")

                    Eliminate.check()
                    SingleNaked.check()
                }
            }

        }
    }
}