package components

import input.FileInput
import mapping.CellMap

object Table {
    private var blocks = Array(9) { i -> Block(i) }
    private var rows = Array(9) { i -> Row(i) }
    private var columns = Array(9) { i -> Column(i) }

    private var cells = Array(81)
    { i -> Cell(i,
                blocks[CellMap.toBlockIndex(i)],
                rows[CellMap.toRow(i)],
                columns[CellMap.toColumn(i)])
    }

    fun eliminate() {
        eliminateFromRowType(rows)
        eliminateFromRowType(columns)
        eliminateFromRowType(blocks)
    }

    private fun <T: Row> eliminateFromRowType(rowTypeArray: Array<T>) {
        for (row in rowTypeArray) {
            row.eliminate()
        }
    }

    fun populateCellsWithValues() {
        var inputArray = FileInput.importIntArrayList()

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
            index % 3 == 2 && index < rows.size - 1 -> "------------------------------\n"
            else -> ""
        }
    }
}
