package components

import mapping.CellIndex
import util.FileInput

class Table {
    var blocks = Array(9) { i -> Block(i) }
    var rows = Array(9) { i -> Row(i) }
    var columns = Array(9) { i -> Column(i) }

    var cells = Array(81)
    { i -> Cell(i,
                blocks[CellIndex.toBlockIndex(i)],
                rows[CellIndex.toRow(i)],
                columns[CellIndex.toColumn(i)])
    }

    fun populateCellsWithValues(filename: String) {
        var inputArray = FileInput.importFileToPuzzleArray(filename)

        if (inputArray.size != cells.size) {
            throw Exception("Invalid input array size: ${inputArray.size}")
        }

        for (i in 0 until cells.size) {
            cells[i].initializeCellValue(inputArray[i])
        }
    }

    override fun toString(): String {
        var tableOut = ""
        for (i in 0 until rows.size) {
            tableOut += "${rows[i]}\n${addHorizontalLineEveryThirdRow(i)}"
        }
        return tableOut
    }

    private fun addHorizontalLineEveryThirdRow(index: Int): String {
        return when {
            index % 3 == 2 && index < rows.size - 1 -> "----------------------\n"
            else -> ""
        }
    }
}
