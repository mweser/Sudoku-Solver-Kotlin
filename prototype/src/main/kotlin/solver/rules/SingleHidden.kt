package solver.rules

import components.Cell
import components.Row
import components.Table

object SingleHidden : RuleCheck() {

    var valuesSet = 0

    override fun check(): Int {
        valuesSet = 0

        for (cell in Table.cells) {
            areAnyUniqueCandidateValue(cell, cell.row, cell.column, cell.block)
        }

        println("\nHidden single check: $valuesSet values set\n")
        return valuesSet
    }

    private fun <T : Row> areAnyUniqueCandidateValue(cell: Cell, vararg rowTypes: T): Boolean {
        for (rowType in rowTypes) if (isUniqueCandidateValue(cell, rowType)) {
            return true
        }
        return false
    }

    private fun <T : Row> isUniqueCandidateValue(cell: Cell, row: T): Boolean {

        


        return false
    }
}