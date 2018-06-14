package solver

import components.CellValue
import util.Logger.valueEliminated

class Candidates(vararg valuesToEliminate: CellValue) {
    var candidates = BooleanArray(10) { true }
    var count = 9

    init {
        candidates[CellValue.NONE.ordinal] = false
        eliminateValue(CellValue.NONE)
    }

    fun eliminateValue(value: CellValue): Boolean {
        if (count > 1) {
            if (isValueInRange(value)) {
                candidates[value.ordinal] = false
                count--
                valueEliminated(value, count)
            }
        }
        return count <= 1
    }

    fun getRemainingCandidate(): CellValue {
        if (count == 1) {
            for (i in 0 until candidates.size) {
                if (candidates[i]) {
                    return CellValue.values()[i]
                }
            }
        }
        return CellValue.NONE
    }

    fun clearAllCandidates() {
        candidates = BooleanArray(10) { false }
    }

    private fun isValueInRange(value: CellValue): Boolean {
        return value.ordinal in CellValue.ONE.ordinal..CellValue.NINE.ordinal
    }
}