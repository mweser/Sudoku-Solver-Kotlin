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
        // todo look into making this a lambda over the collection
        for (cell in cells) if (cell.value == components.CellValue.EMPTY) {
            return false
        }
        return true
    }

    override fun toString(): String {
        return "${printCellValues()}"
    }

    fun printCellValues(): String {
        // todo look into lambda for this
        var values = ""

        for (i in 0 until cells.size) {
            values += "${evenlySpace(cells[i].block.maxRow)} "

            if (i % 3 == 2 && i < cells.size - 1) {
                values += "| "
            }
        }

        return values
    }

    fun evenlySpace(value: String): String {
        return value
    }

    fun evenlySpace(value: Int): String {
        return if (value < 10) {
            " $value"
        } else {
            value.toString()
        }
    }
}

class Row(index: Int) : CellSet(index)

class Column(index: Int) : CellSet(index)

class Block(index: Int) : CellSet(index) {
    val position = BlockMap.toBlockName(index)

    val blockRow = BlockMap.toBlockRow(index)
    val blockColumn = BlockMap.toBlockColumn(index)

    val minRow = BlockMap.toMinRow(index)
    val maxRow = BlockMap.toMaxRow(index)
    val minColumn = BlockMap.toMinColumn(index)
    val maxColumn = BlockMap.toMaxColumn(index)
}