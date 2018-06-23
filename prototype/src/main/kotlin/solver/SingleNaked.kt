package solver

import components.Cell
import components.Table
import util.Logger.printNakedSingleResults

object SingleNaked : RuleCheck() {

    var valuesSet = 0

    override fun check(): Int {
        valuesSet = 0

        for (cell in Table.cells) {
            valuesSet += evaluateCell(cell)
        }

        printNakedSingleResults(this)
        return valuesSet
    }

    fun evaluateCell(cell: Cell): Int {
        var newValuesSet = 0

        if (cell.getNumCandidates() == 1) {
            cell.setValueWithRule(cell.candidates.getRemainingCandidate(), "Naked single")
            newValuesSet++
        }
        return newValuesSet
    }
}