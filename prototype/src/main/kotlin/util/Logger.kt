package util

import components.Cell
import components.CellValue
import components.Row

object Logger {

    fun cellValueInitialized(intValue: Int) {
        println("Cell initialized at ")

    }

    fun valueEliminated(value: CellValue, count: Int) {
//        println("$value eliminated, count at $count")
    }

    fun cellValueUpdated(cell: Cell) {
//        println("Cell {${cell.index + 1} [${cell.row.index + 1},${cell.column.index + 1}]} updated to ${cell.value}")
    }

    fun <T: Row> rowValues(row: T, values: Array<CellValue>) {
//        println("Values in Row ${row.index + 1}: $values")
    }
}