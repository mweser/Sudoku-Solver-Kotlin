package components

import components.CellValue.NINE
import components.CellValue.NONE
import components.CellValue.ONE
import components.CellValue.values
import solver.Candidates
import util.Logger.cellValueUpdated

enum class CellValue {
    NONE, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int, val block: Block, val row: Row, val column: Column) {

    var candidates = Candidates()
    var numCandidates = 9

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
                candidates.clearAllCandidates()
                numCandidates = 0
                isMutable = false
            }
        }

    init { addCellToSets(block, row, column) }

    fun eliminateCandidate(valueToEliminate: CellValue) {
        candidates.eliminateValue(valueToEliminate)
        numCandidates = candidates.count
    }

    fun initializeCellValue(intValue: Int) {
        value = values()[intValue]

        if (intValue in ONE.ordinal..NINE.ordinal) {
            isMutable = false
        }
    }

    private fun <T: Row> addCellToSets(vararg rows: T) {
        for (row in rows) {
            row.addCell(this@Cell)
        }
    }

    fun propertiesToPrint(): String {
        return """
            Cell #${index + 1}  (${row.index + 1}, ${column.index + 1})
            Value: $value
            Mutable: $isMutable
            Candidates: $candidates
            Block #${block.index}: ${block.position}
        """.trimIndent()

    }

    override fun toString(): String {
        return value.toString()
    }
}
