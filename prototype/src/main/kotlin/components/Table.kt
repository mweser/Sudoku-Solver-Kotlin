package components

import mapping.CellMap

class Table {

    var blocks = Array(9) { i -> Block(index = i) }
    var rows = Array(9) { i -> Row(index = i) }
    var columns = Array(9) { i -> Column(index = i) }

    var cells = Array(81) {
        index -> Cell(index,
                CellValue.EMPTY,
                blocks[CellMap.toBlockIndex(index)],
                rows[CellMap.toRow(index)],
                columns[CellMap.toColumn(index)])
    }

    override fun toString(): String {
        var tableOut = ""

        for (i in 0 until rows.size) {
            tableOut += "${rows[i]}\n"

            if (i % 3 == 2 && i < rows.size - 1) {
                tableOut += "------------------------------\n"
            }
        }

        return tableOut
    }
}
