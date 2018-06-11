package components

enum class CellValue {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int,
           val block: Block,
           val row: Row,
           val column: Column,
           var value: CellValue = CellValue.EMPTY) {

    init { addCellToSets(block, row, column) }

    var isOriginal: Boolean = false
    var originalValue: CellValue = CellValue.EMPTY

    private fun <T: Row> addCellToSets(vararg rows: T) {
        for (row in rows) {
            row.addCell(this)
        }
    }

    override fun toString(): String {
        return value.toString()
    }
}
