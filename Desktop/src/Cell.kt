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
    val row: Int
    val column: Int
    val blockIndex: Int
    val blockName: BlockName

    val block: Block
    val row: Row
    val column: Column

}
