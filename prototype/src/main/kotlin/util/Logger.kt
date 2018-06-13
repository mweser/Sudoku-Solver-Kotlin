package util

import components.Cell
import components.CellValue
import components.Row

object Logger {

    fun cellValueInitialized(cell: Cell) {
        println("Cell initialized ${getCellId(cell)}")
    }

    fun valueEliminated(value: CellValue, count: Int) {
//        println("$value eliminated, count at $count")
    }

    fun cellValueUpdated(cell: Cell) {
//        println("Cell value updated ${getCellId(cell)}")
    }

    fun <T: Row> rowValues(row: T, values: Array<CellValue>) {
//        println("Values in Row ${row.index + 1}: $values")
    }

    fun cellSetToImmutable(cell: Cell) {
//        println("Cell set to immutable: ${getCellId(cell)}")
    }

    private fun getCellId(cell: Cell): String {
        return "{${cell.index + 1}: ${cell.value}    [${cell.row.index + 1},${cell.column.index + 1}] Mutable: ${cell.isMutable}}"
    }
}