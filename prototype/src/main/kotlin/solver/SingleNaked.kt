package solver

import components.Cell
import components.Table
import util.Logger.printNakedSingleResults

object SingleNaked : RuleCheck() {

    var valuesSet = 0

    override fun check(table: Table): Int {
        valuesSet = 0

        for (cell in table.cells) {
            valuesSet += evaluateCell(table, cell)
        }

        printNakedSingleResults(this)
        return valuesSet
    }

    fun evaluateCell(table: Table, cell: Cell): Int {
        var newValuesSet = 0

        if (cell.getNumCandidates() == 1) {
            cell.setValueWithRule(cell.candidates.getRemainingCandidate(), "Naked single")
            newValuesSet++
            newValuesSet += Eliminate.check(table)
        }
        return newValuesSet
    }
}