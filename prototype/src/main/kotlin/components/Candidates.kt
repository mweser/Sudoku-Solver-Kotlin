package components

import util.Logger.valueEliminated

class Candidates {
    var candidates = BooleanArray(10) { true }
    var count = 9
        get() {
            var numEnabled = 0
            for (candidate in candidates) if (candidate) {
                numEnabled++
            }
            return numEnabled
        }

    init {
        candidates[CellValue.NONE.ordinal] = false
        eliminateValue(CellValue.NONE)
    }

    fun eliminateValue(value: CellValue) {
        if (isValueInRange(value)) {
            candidates[value.ordinal] = false
            count--
            valueEliminated(value, count)
        }
    }

    fun contains(index: Int): Boolean {
        return candidates[index]
    }

    fun contains(value: CellValue): Boolean {
        return candidates[value.ordinal]
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

    fun assertTrueCandidates(vararg cellValues: CellValue): Boolean {
        if (count != cellValues.size) {
            return false
        }

        for (cellValue in cellValues) {
            if (!candidates[cellValue.ordinal]) {
                return false
            }
        }
        return true
    }

    fun clearAllExcept(vararg values: CellValue): Candidates {
        clearAll()

        for (value in values) {
            candidates[value.ordinal] = true
            count++
        }
        return this
    }

    fun clearAll(): Candidates {
        candidates = BooleanArray(10) { false }
        count = 0
        return this
    }

    fun setAll(): Candidates {
        candidates = BooleanArray(10) { true }
        candidates[CellValue.NONE.ordinal] = false
        count = 9
        return this
    }

    private fun isValueInRange(value: CellValue): Boolean {
        return value.ordinal in CellValue.ONE.ordinal..CellValue.NINE.ordinal
    }

    override fun toString(): String {
        var stringToPrint = ""
        for (i in CellValue.ONE.ordinal..CellValue.NINE.ordinal) {
            if (candidates[i]) {
                stringToPrint += "${CellValue.values()[i]} "
            }
        }
        return stringToPrint
    }
}