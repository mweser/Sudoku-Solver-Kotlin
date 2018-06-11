package components

enum class CellValue {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int, var value: CellValue,
           val block: Block,
           val row: Row,
           val column: Column) {

    init { addCellToSets(block, row, column) }

    fun <T: NineSet> addCellToSets(vararg nineSets: T) {
        for (nineSet in nineSets) {
            nineSet.addCell(this)
        }
    }

    override fun toString(): String {
        return block.position.toString()
    }
}
