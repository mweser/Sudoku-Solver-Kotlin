package solver.rules

import components.Table

object SingleNaked : RuleCheck() {

    var valuesSet = 0

    override fun check(): Int {
        valuesSet = 0

        for (cell in Table.cells) if (cell.numCandidates == 1) {
            cell.value = cell.candidates.getRemainingCandidate()
            valuesSet++
        }

        println("\nNaked single check: $valuesSet values set\n")

        return valuesSet
    }
}