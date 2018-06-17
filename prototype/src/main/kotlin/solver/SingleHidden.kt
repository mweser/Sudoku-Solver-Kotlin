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
            if (areAnyUniqueCandidateValue(cell, cell.row, cell.column, cell.block)) {
                instancesFound++
            }
        }

        println("\nHidden single check: $instancesFound instances found\n")
        return instancesFound
    }

    private fun <T : Row> areAnyUniqueCandidateValue(cell: Cell, vararg rowTypes: T): Boolean {
        for (rowType in rowTypes) if (isUniqueCandidateValue(cell, rowType)) {
            return true
        }
        return false
    }

    private fun <T : Row> isUniqueCandidateValue(cell: Cell, row: T): Boolean {

        for (value in CellValue.ONE.ordinal..CellValue.NINE.ordinal) {
            if (cell.candidates.contains(value)) {
                for (otherCell in row.cells) {
                    if (otherCell != cell && otherCell.candidates.contains(value)) {
                        return false
                    }
                }

                cell.value = CellValue.values()[value]
                println("Hidden single found for ${CellValue.values()[value]} in $cell")
            }
        }
        return true
    }
}