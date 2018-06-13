package solver

import components.CellValue
import util.Logger.valueEliminated

class Candidates(vararg valuesToEliminate: CellValue) {
    var candidates = BooleanArray(9) { true }
    var count = 9

    init { eliminateValues(*valuesToEliminate) }

    fun eliminateValues(vararg values: CellValue) {
        for (value in values) {
            if (isValueInRange(value)) {
                candidates[value.ordinal - 1] = false
                count--
                valueEliminated(value, count)
            }
        }
    }

    fun isValueInRange(value: CellValue): Boolean {
        return value.ordinal in CellValue.ONE.ordinal..CellValue.NINE.ordinal
    }
}