package solver

import components.CellValue

class CandidateSet(vararg valuesToEliminate: CellValue) {

    init { eliminateValues(*valuesToEliminate) }

    var candidates = BooleanArray(9) { true }

    fun eliminateValues(vararg values: CellValue) {
        for (value in values) {
            candidates[value.ordinal] = false
        }
    }
}