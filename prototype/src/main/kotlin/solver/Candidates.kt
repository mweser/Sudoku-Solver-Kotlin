package solver

import components.Cell
import components.CellValue
import util.Logger.valueEliminated

class Candidates(vararg valuesToEliminate: CellValue) {
    var candidates = BooleanArray(10) { true }
    var count = 9

    init {
        candidates[CellValue.NONE.ordinal] = false
        eliminateValues(*valuesToEliminate)
    }

    fun eliminateValues(cells: ArrayList<Cell>): Boolean {
        for (cell in cells) {
            eliminateValues(cell.value)
        }
        return count <= 1
    }

    fun eliminateValues(vararg values: CellValue): Boolean {
        if (count > 1) {
            for (value in values) if (isValueInRange(value)) {
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