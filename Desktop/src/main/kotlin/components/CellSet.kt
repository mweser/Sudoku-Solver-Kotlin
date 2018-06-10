package components

import mapping.BlockMap

abstract class CellSet(val index: Int) {
    var cells = ArrayList<Cell>()
    var size = 0

    fun addCell(cell: Cell): Boolean {
        return if (size > 9) {
            false
        } else {
            cells.add(cell)
            size++
            true
        }
    }

    fun isDone(): Boolean {
        for (cell in cells) if (cell.value == components.CellValue.EMPTY) {
            return false
        }
        return true
    }
}

class Row(index: Int) : CellSet(index)

class Column(index: Int) : CellSet(index)

class Block(index: Int) : CellSet(index) {
    val blockName = BlockMap.toBlockName(index)

    val blockRow = BlockMap.toBlockRow(index)
    val blockColumn = BlockMap.toBlockColumn(index)

    val minRow = BlockMap.toMinRow(index)
    val maxRow = BlockMap.toMaxRow(index)
    val minColumn = BlockMap.toMinColumn(index)
    val maxColumn = BlockMap.toMaxColumn(index)


    override fun toString(): String {
        return "Index: $index, Name: $blockName"
    }
}