package components

enum class CellValue {
    EMPTY, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE
}

class Cell(val index: Int, var value: CellValue,
           val block: Block,
           val row: Row,
           val column: Column) {

    init {
        block.addCell(this)
        row.addCell(this)
        column.addCell(this)
    }


    override fun toString(): String {
        return block.position.toString()
    }
}
