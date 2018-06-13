package components

import solver.Candidates
import util.Logger

open class Row(val index: Int) {
    var cells = ArrayList<Cell>()
    var size = 0
    var candidates = Candidates()

    fun eliminate() {
        val values = Array(9) { i -> cells[i].value }
        Logger.rowValues(this, values)

        for (cell in cells) {
            cell.eliminate(values)
        }
    }

    fun addCell(cell: Cell): Boolean {
        return if (size > 9) {
            false
        } else {
            cells.add(cell)
            candidates.eliminateValues(cell.value)
            size++
            true
        }
    }

    fun isDone(): Boolean {
        for (cell in cells) if (cell.value == CellValue.NONE) {
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
            values += "${checkForNoValue(cells[i].value.ordinal)}${addDividerEveryThirdColumn(i)}"
        }
        return values
    }

    private fun checkForNoValue(value: Int): String {
        return when (value) {
            CellValue.NONE.ordinal -> " _"
            else -> " $value"
        }
    }

    private fun addDividerEveryThirdColumn(columnIndex: Int): String {
        return when {
            columnIndex % 3 == 2 && columnIndex < cells.size - 1 -> "| "
            else -> ""
        }
    }
}

class Column(index: Int): Row(index)