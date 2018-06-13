package solver

import components.CellValue

class Candidates(vararg valuesToEliminate: CellValue) {

    init { eliminateValues(*valuesToEliminate) }

    var candidates = BooleanArray(9) { true }
    var count = 9

    fun eliminateValues(vararg values: CellValue) {
        for (value in values) {
            if (isValueInRange(value)) {
                candidates[value.ordinal] = false
                count--

            }
        }
    }

    fun isValueInRange(value: CellValue): Boolean {
        return value.ordinal in CellValue.ONE.ordinal..CellValue.NINE.ordinal
    }
}