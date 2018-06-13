package components

import components.CellValue.NONE
import components.CellValue.values
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
            if (isMutable) {
                field = value
                cellValueUpdated(this)
                candidates.clearAllCandidates()
                isMutable = false
            }
        }

    var prevValue: CellValue = NONE
    var candidates = Candidates()
    var numCandidates = 9

    init { addCellToSets(block, row, column) }

    fun <T: Row> eliminateFromComponents(vararg rowTypes: T) {
        for (rowType in rowTypes) {
            rowType.eliminate()
        }
    }

    fun eliminate(valuesToEliminate: Array<CellValue>) {
        candidates.eliminateValues(*valuesToEliminate)
        numCandidates = candidates.count

        if (candidates.getRemainingCandidate() != NONE) {
            value = candidates.getRemainingCandidate()
        }
    }

    fun initializeCellValue(intValue: Int) {
        value = values()[intValue]
        candidates = Candidates(value)

        if (intValue in CellValue.ONE.ordinal..CellValue.NINE.ordinal) {
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
