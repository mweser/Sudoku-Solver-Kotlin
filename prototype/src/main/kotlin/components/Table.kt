package components

import mapping.CellMap
import util.FileInput

object Table {
    var blocks = Array(9) { i -> Block(i) }
    var rows = Array(9) { i -> Row(i) }
    var columns = Array(9) { i -> Column(i) }

    var cells = Array(81)
    { i -> Cell(i,
                blocks[CellMap.toBlockIndex(i)],
                rows[CellMap.toRow(i)],
                columns[CellMap.toColumn(i)])
    }

    fun populateCellsWithValues() {
        var inputArray = FileInput.importFileToPuzzleArray("hard03.txt")

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
