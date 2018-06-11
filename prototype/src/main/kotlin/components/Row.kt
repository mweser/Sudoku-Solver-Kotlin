package components

open class Row(val index: Int) {
    var cells = ArrayList<Cell>()
    var size = 0

    fun addCell(cell: Cell): Boolean {
        return if (size > 9) {
            false
        } else {
            cells.add(cell)
            // call elimination
            size++
            true
        }
    }

    fun isDone(): Boolean {
        for (cell in cells) if (cell.value == CellValue.EMPTY) {
            return false
        }
        return true
    }

    override fun toString(): String {
        return "${printCellValues()}"
    }

    private fun printCellValues(): String {
        var values = ""
        for (i in 0 until cells.size) {
            values += "${filter(cells[i].value.ordinal)} "

            if (i % 3 == 2 && i < cells.size - 1) {
                values += "| "
            }
        }
        return values
    }

    private fun filter(value: String): String {
        return value
    }

    private fun filter(value: Int): String {
        return when {
            value == 0 -> "__"
            value < 10 -> " $value"
            else -> value.toString()
        }
    }
}

class Column(index: Int): Row(index)