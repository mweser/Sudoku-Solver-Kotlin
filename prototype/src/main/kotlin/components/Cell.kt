package components

import components.CellValue.NINE
import components.CellValue.NONE
import components.CellValue.ONE
import components.CellValue.values
import util.Logger
import util.Logger.cellValueUpdated

enum class CellValue {
    NONE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int, val block: Block, val row: Row, val column: Column) {

    var candidates = Candidates()
    var rule = "INITIAL"

    var isMutable: Boolean = true
        set(value) {
            if (isMutable) {
                field = value
            }
        }

    var value: CellValue = NONE
        set(value) {
            if (isMutable && value != NONE) {
                field = value
                cellValueUpdated(this)
                candidates.clearAll()
                isMutable = false
            }
        }

    init {
        addCellToSets(block, row, column)
    }

    // todo add more information, such as "along row/column, etc."
    fun setValueWithRule(value: CellValue, rule: String) {
        this.rule = rule
        this.value = value
    }

    fun eliminateCandidate(valueToEliminate: CellValue) {
        candidates.eliminateValue(valueToEliminate)
    }

    fun initializeCellValue(intValue: Int) {
        value = values()[intValue]

        if (intValue in ONE.ordinal..NINE.ordinal) {
            isMutable = false
        }
    }

    private fun <T : Row> addCellToSets(vararg rows: T) {
        for (row in rows) {
            row.addCell(this@Cell)
        }
    }

    fun getNumCandidates(): Int {
        return candidates.count
    }

    override fun toString(): String {
        return return """
            Cell #${index + 1}  (${row.index + 1}, ${column.index + 1})
            Value: $value
            Mutable: $isMutable
            Candidates: $candidates
            Block #${block.index}: ${block.position}

        """.trimIndent()
    }

    fun eliminateAllCandidatesExcept(vararg values: CellValue) {
        candidates.clearAllExcept(*values)
    }

    // todo this can be WAYYYY improved
    fun eliminateCandidates(candidates: Candidates): Int {
        var numEliminated = 0
        for (index in 0 until candidates.candidates.size) {
            if (candidates.candidates[index] && this.candidates.candidates[index]) {
                this.candidates.candidates[index] = false
                numEliminated++
                Logger.printEliminateCandidatesFromCell(this, candidates)
            }
        }
        return numEliminated
    }
}
