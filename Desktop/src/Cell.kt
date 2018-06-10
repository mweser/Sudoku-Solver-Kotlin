enum class CellValue {
    EMPTY,
    ONE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE
}

class Cell(val index: Int, var value: CellValue) {
    val rowIndex: Int = BlockMap.findCellRow(index)
    val columnIndex: Int = BlockMap.findCellColumn(index)
    val blockIndex: Int =
    val blockName: BlockName

    val block: Block
    val row: Row
    val column: Column

}
