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

    fun printBlocks() {

//        for (item in blocks) {
//            println(item)
//        }

        for (item in rows) {
            println(item)
        }
//
//        for (item in columns) {
//            println(item)
//        }
    }
}
