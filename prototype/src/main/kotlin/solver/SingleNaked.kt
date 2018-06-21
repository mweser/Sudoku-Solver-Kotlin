package solver

import components.Table
import util.Logger.printNakedSingleResults

object SingleNaked : RuleCheck() {

    var valuesSet = 0

    override fun check(): Int {
        valuesSet = 0

        for (cell in Table.cells) if (cell.getNumCandidates() == 1) {
            cell.value = cell.candidates.getRemainingCandidate()
            valuesSet++
            Eliminate.check()
        }

        printNakedSingleResults(this)
        return valuesSet
    }
}