package components

import components.CellValue.EMPTY
import components.CellValue.values

enum class CellValue {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int, val block: Block, val row: Row, val column: Column) {

    var isMutable: Boolean = true
        set(value) {
            field = isMutable
        }

    var prevValue: CellValue = EMPTY

    init { addCellToSets(block, row, column) }

    var value: CellValue = EMPTY
        set(value) {
            if (isMutable) {
                field = value
            }
        }

    fun initializeCellValue(intValue: Int) {
        value = values()[intValue]

        if (intValue in 1..9) {
            isMutable = false
        }
    }

    private fun <T: Row> addCellToSets(vararg rows: T) {
        for (row in rows) {
            row.addCell(this)
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
