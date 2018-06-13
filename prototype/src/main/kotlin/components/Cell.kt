package components

import components.CellValue.*
import solver.Candidates
import util.Logger
import util.Logger.cellValueUpdated

enum class CellValue {
    NONE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int, val block: Block, val row: Row, val column: Column) {

    var isMutable: Boolean = true
        set(value) {
            if (isMutable) {
                field = value
            }

            if (!isMutable) {
                Logger.cellSetToImmutable(this)
            }
        }

    var value: CellValue = NONE
        set(value) {
            if (isMutable && value != NONE) {
                field = value
                cellValueUpdated(this)
                candidates.clearAllCandidates()
                numCandidates = 0
                isMutable = false
            }
        }

    var prevValue: CellValue = NONE
    var candidates = Candidates()
    var numCandidates = 9

    init { addCellToSets(block, row, column) }

    fun eliminate() {
        if (isMutable) {
            var values = ArrayList<CellValue>()
            values.addAll(row.values)
            values.addAll(column.values)
            values.addAll(block.values)

            for (i in ONE.ordinal..NINE.ordinal) if (values.contains(CellValue.values()[i])) {
                eliminate(CellValue.values()[i])
            }
        }
    }

    fun eliminate(valueToEliminate: CellValue) {
        candidates.eliminateValue(valueToEliminate)
        numCandidates = candidates.count

        if (numCandidates == 1) {
            value = candidates.getRemainingCandidate()
        }
    }

    fun initializeCellValue(intValue: Int) {
        value = values()[intValue]
        candidates = Candidates(value)

        if (intValue in ONE.ordinal..NINE.ordinal) {
            isMutable = false
        }
    }

    private fun <T: Row> addCellToSets(vararg rows: T) {
        for (row in rows) {
            row.addCell(this@Cell)
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
