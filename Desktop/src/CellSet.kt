import BlockMap.Companion.findBlockColumnFromIndex
import BlockMap.Companion.findBlockRowFromIndex

abstract class CellSet(val index: Int) {
    var cells = Array(9, { Cell(CellValue.EMPTY) })

    fun isDone(): Boolean {
        for (cell in cells) if (cell.value == CellValue.EMPTY) {
            return false
        }
        return true
    }
}

class Row(index: Int) : CellSet(index) {

}

class Column(index: Int) : CellSet(index) {

}

class Block(index: Int) : CellSet(index) {
    val blockName = BlockName.values()[index]

    val blockRow = findBlockRowFromIndex(index)
    val blockColumn = findBlockColumnFromIndex(index)

    val minRow = blockRow * 3
    val maxRow = minRow + 2
    val minColumn = blockColumn * 3
    val maxColumn = minColumn + 2




    override fun toString(): String {
        return "Index: $index, Name: $blockName"
    }
}